import {Component, OnInit, ViewChild} from '@angular/core';
import { State } from '../spring-calender-server';
import {MatSort,MatTableDataSource} from "@angular/material";
import {MatPaginator,MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {Observable} from "rxjs";
import {StatesService} from '../service/states.service';
import {SelectionModel} from "@angular/cdk/collections";
import {
  CommonDeleteDialog, CommonAddDialog, CommonUpdateDialog,
  CommonAdvSearchDialog
} from '../common-dialog/common-component';
import {CountryService} from "../service/country.service";
import {DeleteDialog} from "../holidays/edit-holidays/edit-holidays.component";
@Component({
  selector: 'app-states',
  templateUrl: './states.component.html',
  styleUrls: ['./states.component.css']
})
export class StatesComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  addState: State = new State();
  updateState: State = new State();
  deleteStates: State[];
  searchSource : MatTableDataSource<any>;
  searchObject : State = new State();

  selection = new SelectionModel<State>(true, []);
  objectKeys = Object.keys;
  dataSource: MatTableDataSource<any>;
  states: Observable<State[]>;
  displayedColumns: string[] = [];

  isShowSearchTable = 'none';
  isShowGeneralTable = 'block';
  isDisableDelete = true;

  searchMenus = {
    'country': [],
  };

  //constructor-------------------------------------------------------------------------------------------------------------
  constructor(private statesService: StatesService,
              private countryService: CountryService,
              private dialog: MatDialog) {
  }


  //useful component for table representation
  @ViewChild('scheduledOrdersPaginator') generalPaginator: MatPaginator;
  @ViewChild('searchPaginator') searchPaginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    this.getStates();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngAfterViewInit() {
    this.countryService
      .getCountries()
      .subscribe(countrys => {
        //this.states = states;
        this.searchMenus['country'] = countrys;
        // console.log(" loading data country ", this.mappingData['country']);
      });
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    //console.log("number of selected row ",numRows);
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();

    }
    else {
      this.dataSource.data.forEach(row => this.selection.select(row));
    }

    console.log("select ", this.selection);
  }

  changeOptions(event) {

    console.log("selection len", this.selection);

    console.log("change has value ", this.selection.hasValue());
    console.log("Selected ", this.selection);
    if (this.selection.hasValue()) {
      this.isDisableDelete = false;
      this.deleteStates = this.selection.selected;
    } else {
      this.isDisableDelete = true;
    }
  }

  //fetch general table info from database
  getStates() {
    this.statesService
      .getStates()
      .subscribe(states => {
        this.states = states;
        console.log("get states ", states);
        this.dataSource = new MatTableDataSource<State>(states);
        this.dataSource.paginator = this.generalPaginator;
        this.dataSource.sort = this.sort;
      });

    this.statesService
      .getStatesFields()
      .subscribe(displayColumns => {
        this.displayedColumns = ['select'];
        this.displayedColumns = this.displayedColumns.concat(displayColumns);
        this.displayedColumns.push("update");
        this.displayedColumns.push("delete");
      })
  }

  //functions that click different dialog
  openAddDialog(): void {
    const dialogRef = this.dialog.open(CommonAddDialog, {
      width: '500px',
      data: {
        State: this.addState,
        entityName: 'State',
        fields: this.displayedColumns,
        searchMenus: this.searchMenus,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add dialog was closed');
      if (result == 'submit') {
        console.log('The element to be update ', this.addState);

        this.statesService
          .createState(this.addState)
          .subscribe(data => {
            this.getStates();
          })
      } else {

      }

      this.addState = new State();
    });
  }

  openDeleteDialog(deleteId: number) {
    console.log("the deleteId is " + deleteId)
    const dialogRef = this.dialog.open(CommonDeleteDialog, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The delete dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if (result == 'submit') {
        this.statesService.deleteState(deleteId).subscribe(data=> {
          console.log(data);
          this.getStates();
        });
      } else {

      }
    });
  }


  openUpdateDialog(state: any) {
    var isByRow = false;
    if (state !== undefined) {
      console.log("the updateId is " + state.id);
      this.updateState = state;
      isByRow = true;
    }
    else {
      console.log("general update");

    }
    const dialogRef = this.dialog.open(CommonUpdateDialog, {
      width: '500px',
      data: {
        updateState: this.updateState,
        entityName: 'updateState',
        fields: this.displayedColumns,
        searchMenus: this.searchMenus,
        isByRow: isByRow
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The update dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if (result == 'submit') {

        this.statesService
          .updateState(this.updateState.id, this.updateState)
          .subscribe(data => {
            this.getStates();
          })
        console.log("the element to be update ", this.updateState);

      } else {

      }
      // initialized
      this.updateState = new State();
    });
  }

  deletedSelectedStates() {
    console.log("holiday to be delete ", this.deleteStates);
    var list = this.deleteStates.map(state=> {
      return state.id
    });

    const dialogRef = this.dialog.open(CommonDeleteDialog, {
      width: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if (result == 'submit') {
        this.statesService.deleteSelectedStates(list)
          .subscribe(data => {
            this.getStates();
            this.selection.clear();
            this.isDisableDelete = true;
          })
        console.log("list ", list);
      } else {

      }
    });


  }

  openSearchDialog(field: any, value: any): void {

    this.searchObject[field] = value;

    this.statesService
      .getSearchStates(this.searchObject)
      .subscribe(searchResults => {
          this.searchSource = new MatTableDataSource<State>(searchResults);
        this.isShowSearchTable= 'block';
        this.isShowGeneralTable = 'none';
        this.searchSource.paginator = this.searchPaginator;
        console.log("data source ",this.searchSource);
        //console.log(this.holidaysLocalesDetails[this.holidaysLocalesDetails.length-1].holiday);
        this.searchObject = new State();
      });

  }

  openAdvSearchDialog(){
    const dialogRef = this.dialog.open(CommonAdvSearchDialog, {
      width: '500px',
      data: {
        searchObject : this.searchObject,
        entityName :'searchObject',
        fields : this.displayedColumns,
        searchMenus: this.searchMenus
      }
    });

    dialogRef.afterClosed().subscribe(result => {

      if(result =='submit'){
        this.statesService
          .getSearchStates(this.searchObject)
          .subscribe(result => {
            this.searchSource = new MatTableDataSource<State>(result);
            this.isShowSearchTable= 'block';
            this.isShowGeneralTable = 'none';
            this.searchSource.paginator = this.searchPaginator;
            console.log("data source ",this.searchSource);
            this.searchObject = new State();
          });


      }else{
        this.searchObject = new State();
      }
    });
}


  back(){
    this.isShowSearchTable = 'none';
    this.isShowGeneralTable = 'block';
  }
}
