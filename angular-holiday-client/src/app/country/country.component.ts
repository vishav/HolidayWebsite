import { Component, OnInit, Inject ,ViewChild, AfterViewInit} from '@angular/core';
import { Country } from '../spring-calender-server';
import {MatSort,MatTableDataSource} from "@angular/material";
import {MatPaginator,MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {Observable} from "rxjs";
import {CountryService} from '../service/country.service';
import {SelectionModel} from "@angular/cdk/collections";
import {
  CommonDeleteDialog, CommonAddDialog, CommonUpdateDialog,
  CommonAdvSearchDialog, CommonErrorDialog
} from '../common-dialog/common-component';
import {DeleteDialog} from "../holidays/edit-holidays/edit-holidays.component";
@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  country : Country = new Country();
  addCountry : Country = new Country();
  updateCountry: Country = new Country();
  deleteCountries: Country[];
  searchCountry = new Country();
  conuntries: Observable<Country[]>;

  dataSource: MatTableDataSource<any>;
  searchSource: MatTableDataSource<any>;
  displayedColumns : string[] = ['select'];

  selection = new SelectionModel<Country>(true, []);

  isShowSearchTable= 'none';
  isShowGeneralTable = 'block';

  isDisableDelete = true;

  searchMenus = {
    'state':  [],
    'country':[],
    'holiday':[],
    'city':[],

  };
  //constructor-------------------------------------------------------------------------------------------------------------
  constructor(private countryService: CountryService,
              private dialog: MatDialog) { }

  //useful component for table representation
  @ViewChild('scheduledOrdersPaginator') generalPaginator: MatPaginator;
  @ViewChild('searchPaginator') searchPaginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    this.getCountries();
  }


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  //fetch general table info from database
  getCountries(){
    this.countryService
      .getCountries()
      .subscribe(countries => {
        this.conuntries = countries;
        console.log("get countries ", countries);
        this.dataSource = new MatTableDataSource<Country>(countries);
        this.dataSource.paginator = this.generalPaginator;
        this.dataSource.sort = this.sort;
      });

    this.countryService
      .getCountrysFields()
      .subscribe(displayColumns => {
        this.displayedColumns = ['select'];
        this.displayedColumns = this.displayedColumns.concat(displayColumns);
        this.displayedColumns.push("update");
        this.displayedColumns.push("delete");
        //this.displayedColumns.push("select");

      })
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
    if(this.isAllSelected() ){
      this.selection.clear() ;

    }
    else {
      this.dataSource.data.forEach(row => this.selection.select(row));
    }

    console.log("select ", this.selection);
  }

  changeOptions(event){

    console.log("selection len",this.selection );

    console.log("change has value ", this.selection.hasValue());
    console.log("Selected ", this.selection);
    if(this.selection.hasValue()) {
      this.isDisableDelete = false;
      this.deleteCountries= this.selection.selected;
    }else{
      this.isDisableDelete =true;
    }
  }


  //functions that click different dialog
  openAddDialog(): void {
    const dialogRef = this.dialog.open(CommonAddDialog, {
      width: '500px',
      data: {
        Country : this.addCountry,
        entityName   : 'Country',
        fields : this.displayedColumns,
        //searchMenus: this.searchMenus,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The update dialog was closed');
      if(result =='submit'){
          this.countryService
            .createCountry(this.addCountry)
            .subscribe(data=>{
              console.log(data);
              this.getCountries();
            },
              error =>{
                const dialogRef = this.dialog.open(CommonErrorDialog, {
                  width: '500px',
                  data: {error:error}
                });
                dialogRef.afterClosed().subscribe(result => {});
              })
      }else{

      }
    });
  }

  openDeleteDialog(deleteId: number){
    console.log("the deleteId is "+deleteId)
    const dialogRef = this.dialog.open(CommonDeleteDialog, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The delete dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if(result =='submit'){
        this.countryService.deleteCountry(deleteId).subscribe( data=> {
          console.log(data);
          this.selection.clear();
          this.getCountries();
        },
          error =>{
            const dialogRef = this.dialog.open(CommonErrorDialog, {
              width: '500px',
              data: {error:error}
            });
            dialogRef.afterClosed().subscribe(result => {});
          });
      }else{

      }
    });
  }



  openUpdateDialog(country: any){
    var isByRow = false;
    if(country !== undefined) {
      console.log("the updateId is "+country.id);
      this.updateCountry = country;
      isByRow = true;
    }
    else {
      console.log("general update");

    }
    const dialogRef = this.dialog.open(CommonUpdateDialog, {
      width: '500px',
      data: {
        updateCountry: this.updateCountry,
        entityName  :'updateCountry',
        fields: this.displayedColumns,
        isByRow: isByRow
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The update dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if(result =='submit'){

        this.countryService.updateCountry(this.updateCountry.id, this.updateCountry)
          .subscribe( data=> {
          console.log(data);
          this.getCountries();

        },
            error =>{
              const dialogRef = this.dialog.open(CommonErrorDialog, {
                width: '500px',
                data: {error:error}
              });
              dialogRef.afterClosed().subscribe(result => {});
            });
        console.log("the element to be update ", this.updateCountry);

      }else{

      }
      // initialized
      this.updateCountry = new Country();
    });
  }

  deletedSelectedCountries(){
    console.log("holiday to be delete ", this.deleteCountries);
    var list =this.deleteCountries.map(country=>{
      return country.id
    });

    const dialogRef = this.dialog.open(DeleteDialog, {
      width: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add ialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if(result =='submit'){
        this.countryService.deleteSelectedCountry(list)
          .subscribe(data => {
            this.getCountries();
            this.selection.clear();
            this.isDisableDelete = true;
          })
        console.log("list ",list);
      }else{

      }
    });



  }

  openSearchDialog(){
    const dialogRef = this.dialog.open(CommonAdvSearchDialog, {
      width: '500px',
      data: {
        searchCountry: this.searchCountry,
        entityName  :'searchCountry',
        fields: this.displayedColumns,
        searchMenus: this.searchMenus
      }
    });

    dialogRef.afterClosed().subscribe(result => {

      if(result =='submit'){
        this.countryService
          .getSearch(this.searchCountry)
          .subscribe(searchResult => {
            this.searchSource = new MatTableDataSource<Country>(searchResult);
            this.isShowSearchTable= 'block';
            this.isShowGeneralTable = 'none';
            this.searchSource.paginator = this.searchPaginator;
            this.refresh();
          },
            error =>{
              const dialogRef = this.dialog.open(CommonErrorDialog, {
                width: '500px',
                data: {error:error}
              });
              dialogRef.afterClosed().subscribe(result => {});
            } )

      }else{
        this.refresh();
      }
    });
  }

  back(){
    this.isShowSearchTable = 'none';
    this.isShowGeneralTable = 'block';
  }
  refresh(){
    this.country = new Country();
    this.addCountry = new Country();
    this.updateCountry = new Country();
    this.deleteCountries = [];
    this.searchCountry = new Country();
  }



}
