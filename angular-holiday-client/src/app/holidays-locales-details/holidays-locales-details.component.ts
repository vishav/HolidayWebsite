import { Component, OnInit, Inject ,ViewChild, AfterViewInit} from '@angular/core';
import {HolidaysLocalesDetailsService } from '../service/holidays-locales-details.service';
import {HolidaysService} from '../service/holidays.service';
import {StatesService} from '../service/states.service';
import {CountryService} from '../service/country.service';
import {CitiesService} from '../service/cities.service';
import {HolidaysLocalesDetails} from '../spring-calender-server';
import {MatSort,MatTableDataSource} from "@angular/material";
import {MatPaginator,MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {Observable} from "rxjs";
import {Country, Holiday, State, City} from '../spring-calender-server';
import {DeleteDialog} from '../holidays/edit-holidays/edit-holidays.component';
import {SelectionModel} from "@angular/cdk/collections";
import {CommonErrorDialog, CommonDeleteDialog} from "../common-dialog/common-component";

@Component({
  selector: 'app-holidays-locales-details',
  templateUrl: './holidays-locales-details.component.html',
  styleUrls: ['./holidays-locales-details.component.css']
})
export class HolidaysLocalesDetailsComponent implements OnInit {
  //mappingData =  {};

  holidaysLocalesDetails : Observable<HolidaysLocalesDetails[]>;
  holidaysLocalesDetailsSource : MatTableDataSource<any>;
  searchHolidaysLocalesDetailsSource : MatTableDataSource<any>;
  searchSource : MatTableDataSource<any>;

  holidays: Observable<Holiday[]>;
  states: Observable<State[]>;
  countrys : Observable<Country[]>;
  country : Country;

  displayedColumns: string[] = ['position', 'name' ,'state', 'city'];

  isShowSearchTable= 'none';
  isShowGeneralTable = 'block';

  objectKeys = Object.keys;

  // nested search menu
  // repalce by dynamic
  searchMenus = {
                  'state':  [],
                  'country':[],
                  'holiday':[],
                  'city':[],
                };

  // variable use for checkbox and selected and deleted
  selection = new SelectionModel<any>(true, []);
  deleteObjects: any;
  isDisableDelete = true;

  displayedColumns2 : string[] = [];
  displayedColumns3 : string[];

  addHolidayLocalesDetail : HolidaysLocalesDetails = new HolidaysLocalesDetails();
  updateHolidayLocalesDetail : HolidaysLocalesDetails = new HolidaysLocalesDetails();
  searchHolidayLocalesDetail : HolidaysLocalesDetails = new HolidaysLocalesDetails();
  /*
  listmap = new Map([
    [ "addDisplay",    'none' ],
    [ "updateDisplay", 'none'],
    [ "removeDisplay", 'none' ],
    [ "searchDisplay", 'none' ],
  ]);

  name: string;
  */
  constructor(private holidaysLocalesDetailsService :HolidaysLocalesDetailsService,
              private holidaysService: HolidaysService,
              private statesService: StatesService,
              private countryService: CountryService,
              private cityService: CitiesService,
              public dialog: MatDialog) { }

  @ViewChild('scheduledOrdersPaginator') generalPaginator: MatPaginator;
  @ViewChild('searchPaginator') searchPaginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
  this.getHolidaysLocalesDetails();
    /*
  this.country = new Country();
  this.country.id = 1;
  this.country.name ="test"; */
}


  applyFilter(filterValue: string) {
    this.holidaysLocalesDetailsSource.filter = filterValue.trim().toLowerCase();
  }

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.holidaysLocalesDetailsSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    if(this.isAllSelected() ){
      this.selection.clear() ;
    }
    else {
      this.holidaysLocalesDetailsSource.data.forEach(row => this.selection.select(row));
    }
  }

  changeOptions(event){
    if(this.selection.hasValue()) {
      this.isDisableDelete = false;
      this.deleteObjects= this.selection.selected;
    }else{
      this.isDisableDelete =true;
    }
  }

  ngAfterViewInit() {
    this.holidaysService
      .getHolidays()
      .subscribe(holidays => {
        this.holidays = holidays;
      // this.mappingData['holiday'] = holidays;
        this.searchMenus['holiday'] = holidays;

      });

    this.statesService
      .getStates()
      .subscribe(states => {
        this.states = states;
     //   [].push.apply(this.mappingData, states);
     //   this.mappingData['state'] = states;
        this.searchMenus['state'] = states;
     //   console.log(" loading data state ", this.mappingData['state']);
      });

    this.countryService
      .getCountries()
      .subscribe(countrys => {
        this.countrys = countrys;
     //   this.mappingData['country'] = countrys;
        this.searchMenus['country'] = countrys;
    //    console.log(" loading data country ", this.mappingData['country']);
      });

    this.cityService
      .getCities()
      .subscribe(cities => {
        this.searchMenus['city'] = cities
        });

  }

  openAdvSearchDialog(holidaysLocalesDetails: HolidaysLocalesDetails){
    const dialogRef = this.dialog.open(HolidaysLocalesDetailsAdvSearchDialog, {
      width: '500px',
      data: {
        holidaysLocalesDetails : this.searchHolidayLocalesDetail,
        fields : this.displayedColumns2,
        searchMenus: this.searchMenus
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add ialog was closed');
      console.log(this.searchHolidayLocalesDetail);
      if(result =='submit'){
        this.advSearchHolidays(this.searchHolidayLocalesDetail);
      }else{
      }
    });
  }

  openSearchDialog(field: any, value: any): void {

    this.searchHolidayLocalesDetail[field] = value;
    this.holidaysLocalesDetailsService
      .getSearchHolidaysLocalesDetails(this.searchHolidayLocalesDetail)
      .subscribe(searchHolidaysLocalesDetails => {
        this.searchHolidaysLocalesDetailsSource = new MatTableDataSource<HolidaysLocalesDetails>(searchHolidaysLocalesDetails);
        this.isShowSearchTable= 'block';
        this.isShowGeneralTable = 'none';
        this.searchHolidaysLocalesDetailsSource.paginator = this.searchPaginator;
        this.searchHolidaysLocalesDetailsSource.sort = this.sort;
        this.searchHolidayLocalesDetail = new HolidaysLocalesDetails();
      });

  }

  openAddDialog(): void {
    const dialogRef = this.dialog.open(HolidaysLocalesDetailsAddDialog, {
      width: '500px',
      data: {
        holidaysLocalesDetails : this.addHolidayLocalesDetail,
        fields : this.displayedColumns2,
        searchMenus: this.searchMenus,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result =='submit'){
        console.log("to be add", this.addHolidayLocalesDetail);
        this.addHolidays(this.addHolidayLocalesDetail);
      }else{
        this.refresh();
      }
    });
  }


  openDeleteDialog(deleteId: number){
    console.log("the deleteId is "+deleteId)
    const dialogRef = this.dialog.open(DeleteDialog, {
      width: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result =='submit'){
        this.deleteHolidaysLocalesDetails(deleteId);
      }else{
        this.refresh();
      }
    });
  }

  deleteHolidaysLocalesDetails(deleteId: number){
    console.log("delete locale record by id "+ deleteId);
    this.holidaysLocalesDetailsService
      .deleteHolidaysLocalesDetails(deleteId)
      .subscribe(data => {
          this.getHolidaysLocalesDetails();
        },
        error =>{
          const dialogRef = this.dialog.open(CommonErrorDialog, {
            width: '500px',
            data: {error:error}
          });
          dialogRef.afterClosed().subscribe(result => {});
        }
      );
  }

  deletedSelectedObjects() {
    console.log("selected objects to be delete ", this.deleteObjects);
    var list = this.deleteObjects.map(objects=> {
      return objects.id
    });
    const dialogRef = this.dialog.open(CommonDeleteDialog, {
      width: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
        if (result == 'submit') {
          this.holidaysLocalesDetailsService.deleteSelectedObjects(list)
            .subscribe(data => {
              this.selection.clear();
              this.isDisableDelete = true;
              this.getHolidaysLocalesDetails();
            },
              error =>{
                const dialogRef = this.dialog.open(CommonErrorDialog, {
                  width: '500px',
                  data: {error:error}
                });
                dialogRef.afterClosed().subscribe(result => {});
              })
        } else {
          this.refresh();
        }
      }
    );
  }

  openUpdateDialog(updateHolidayLocalesDetails: any): void {
    var isRow = false;
    if(updateHolidayLocalesDetails !==undefined){
      this.updateHolidayLocalesDetail = updateHolidayLocalesDetails;
      isRow = true;
    }

    const dialogRef = this.dialog.open(HolidaysLocalesDetailsUpdateDialog, {
      width: '500px',
      data: {
        holidaysLocalesDetails : this.updateHolidayLocalesDetail,
        fields : this.displayedColumns2,
        searchMenus: this.searchMenus,
        isRow : isRow
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The update dialog was closed');
      if(result =='submit'){
        this.updateHolidaysLocaleDetail();
      }else{
        this.refresh();
      }
    });
  }

  updateHolidaysLocaleDetail():void {
    console.log("update holiday locale detail to the db!");
    this.holidaysLocalesDetailsService
      .updateHolidaysLocalesDetails(this.updateHolidayLocalesDetail.id,this.updateHolidayLocalesDetail)
      .subscribe(data => {
          console.log(data)
          this.getHolidaysLocalesDetails();
        },
        error =>{
          const dialogRef = this.dialog.open(CommonErrorDialog, {
            width: '500px',
            data: {error:error}
          });
          dialogRef.afterClosed().subscribe(result => {});
        }
      );


    this.ngOnInit();
  }

  advSearchHolidays (holidayLocalesDetail: HolidaysLocalesDetails) : void {
      console.log("search holiday locale detail to the db!", this.searchHolidayLocalesDetail);
      this.holidaysLocalesDetailsService
         .getSearchHolidaysLocalesDetails(this.searchHolidayLocalesDetail)
          .subscribe(searchHolidaysLocalesDetails => {
            this.searchHolidaysLocalesDetailsSource = new MatTableDataSource<HolidaysLocalesDetails>(searchHolidaysLocalesDetails);
            this.isShowSearchTable= 'block';
            this.isShowGeneralTable = 'none';
            this.searchHolidaysLocalesDetailsSource.paginator = this.searchPaginator;
          },
            error =>{
              const dialogRef = this.dialog.open(CommonErrorDialog, {
                width: '500px',
                data: {error:error}
              });
              dialogRef.afterClosed().subscribe(result => {});
            });
  }
  addHolidays(holidayLocalesDetail: HolidaysLocalesDetails): void {
    console.log("add holiday locale detail to the db!");
    this.holidaysLocalesDetailsService
      .createHolidaysLocalesDetails(this.addHolidayLocalesDetail)
      .subscribe(data =>
      {
        this.getHolidaysLocalesDetails();
      },
        error =>{
          const dialogRef = this.dialog.open(CommonErrorDialog, {
            width: '500px',
            data: {error:error}
          });
          dialogRef.afterClosed().subscribe(result => {});
        });
  }

  getHolidaysLocalesDetails(): void {
    //Subscribe in HolidaysComponent
    this.holidaysLocalesDetailsService
      .getHolidaysLocalesDetails()
      .subscribe(holidaysLocalesDetails => {
        this.holidaysLocalesDetails = holidaysLocalesDetails;
        this.holidaysLocalesDetailsSource = new MatTableDataSource<HolidaysLocalesDetails>(holidaysLocalesDetails);
        this.holidaysLocalesDetailsSource.paginator = this.generalPaginator;
        this.holidaysLocalesDetailsSource.sort = this.sort;
        //console.log(this.holidaysLocalesDetails[this.holidaysLocalesDetails.length-1].holiday);
        console.log("holidaysLocalesDetailsSource ", this.holidaysLocalesDetailsSource);
        this.getSetOfMenus([]);
        this.refresh();
      });

    this.holidaysLocalesDetailsService
      .getHolidaysLocalesDetailsFields()
      .subscribe(displayedColumns2 => {
        this.displayedColumns2 = ['select'];
        this.displayedColumns2 = this.displayedColumns2.concat(displayedColumns2);
        this.displayedColumns2.push("update");
        this.displayedColumns2.push("delete");
        this.displayedColumns3 = displayedColumns2;
        console.log("columns Show ", this.displayedColumns2);
      });
  }
/*
  openOneDialog(dialog: string){
    this.hideAllDialog();
    this.listmap.set(dialog,"block");
    console.log("block this one", dialog);
  }
  hideAllDialog(){
    this.listmap.forEach((value: string, key: string) => {
      this.listmap.set(key,"none");
      console.log("close dialog "+key);
    });
  }
*/
  back(){
    this.isShowSearchTable = 'none';
    this.isShowGeneralTable = 'block';
  }

  getSetOfMenus(sets: any) : any {
    var arr = {
      banksclosed:[],
      businessesclosed: [],
      dis:[],
      religion:[],
      holidaytype:[],
      metroarea:[],
    };

    this.holidaysLocalesDetailsSource.data.forEach(function(value){
        //console.log("every column ", value);
      Object.keys(arr).forEach(key =>{
        if(value[key]!== undefined && !arr[key].includes(value[key]) &&value[key]!=='' && value[key]!==null ){
          arr[key].push(value[key]);
        }

      });

  });
    Object.keys(arr).forEach(key => {
      this.searchMenus[key] = arr[key];
    });
    return Array.from(sets);
  }

  refresh(){
    this.addHolidayLocalesDetail  = new HolidaysLocalesDetails();
    this.updateHolidayLocalesDetail = new HolidaysLocalesDetails();
    this.searchHolidayLocalesDetail  = new HolidaysLocalesDetails();
    this.deleteObjects =[];
  }
}


@Component({
  selector: 'holidays-locales-details-add-dialog',
  templateUrl: 'add-dialog.html',
})
export class  HolidaysLocalesDetailsAddDialog {

  constructor(
    public dialogRef: MatDialogRef<HolidaysLocalesDetailsAddDialog>,
    @Inject(MAT_DIALOG_DATA) public data: HolidaysLocalesDetails,
    @Inject(MAT_DIALOG_DATA) public fields: string[]) {}


  onNoClick(): void {
    this.dialogRef.close("cancel");
  }

  onSubmitClick(): void {
    this.dialogRef.close("submit");
  }

}

@Component({
  selector: 'holidays-locales-details-update-dialog',
  templateUrl: 'update-dialog.html',
})
export class  HolidaysLocalesDetailsUpdateDialog {

  constructor(public dialogRef: MatDialogRef<HolidaysLocalesDetailsAddDialog>,
              @Inject(MAT_DIALOG_DATA) public data: HolidaysLocalesDetails,
              @Inject(MAT_DIALOG_DATA) public fields: string[]) {
  }


  onNoClick(): void {
    console.log("data ");
    this.dialogRef.close("cancel");
  }

  onUpdateClick(): void {
    this.dialogRef.close("submit");
  }
}


  @Component({
    selector: 'holidays-locales-details-adv-search-dialog',
    templateUrl: 'adv-search-dialog.html',
  })
  export class  HolidaysLocalesDetailsAdvSearchDialog {

  constructor(
    public dialogRef: MatDialogRef<HolidaysLocalesDetailsAddDialog>,
    @Inject(MAT_DIALOG_DATA) public data: {holidaysLocalesDetails: HolidaysLocalesDetails, fields: string[]}){

    }

  onNoClick(): void {
    //console.log("on no click", this.data);
    console.log("data ", this.data);
    this.dialogRef.close("cancel");
  }

  onAdvSearchClick(): void {
    this.dialogRef.close("submit");
  }



}
