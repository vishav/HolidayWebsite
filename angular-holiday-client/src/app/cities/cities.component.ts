import { Component, OnInit, Inject ,ViewChild, AfterViewInit } from '@angular/core';
import { City } from '../spring-calender-server';
import {MatSort,MatTableDataSource} from "@angular/material";
import {MatPaginator,MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {Observable} from "rxjs";
import {CitiesService} from '../service/cities.service';
import {
  CommonDeleteDialog, CommonAddDialog, CommonUpdateDialog,
  CommonAdvSearchDialog, CommonErrorDialog
} from '../common-dialog/common-component';
import {CountryService} from "../service/country.service";
import {StatesService} from "../service/states.service";
import {SelectionModel} from "@angular/cdk/collections";
@Component({
  selector: 'app-cities',
  templateUrl: './cities.component.html',
  styleUrls: ['./cities.component.css']
})
export class CitiesComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  city : City = new City();
  addCity : City = new City();
  updateCity: City = new City();
  searchCity: City = new City();
  deleteCities: City[];
  deleteObject: any;
  deleteObjects: any;
  selection = new SelectionModel<any>(true, []);
  dataSource: MatTableDataSource<any>;
  searchSource: MatTableDataSource<any>;
  cities: Observable<City[]>;
  displayedColumns : string[] = [];
  tempcountrys= new Map();
  tempstates= new Map();

  isShowSearchTable= 'none';
  isShowGeneralTable = 'block';
  isDisableDelete = true;
  objectKeys = Object.keys;

  searchMenus = {
    'country':[],
    'state':[]
  };


  constructor(private cityService: CitiesService,
              private countryService: CountryService,
              private statesService: StatesService,
              private dialog: MatDialog) { }

  //useful component for table representation
  @ViewChild('scheduledOrdersPaginator') generalPaginator: MatPaginator;
  @ViewChild('searchPaginator') searchPaginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    this.getCities();
  }

  ngAfterViewInit() {
    this.countryService
      .getCountries()
      .subscribe(countrys => {
        //this.states = states;
        this.searchMenus['country'] = countrys;
        // console.log(" loading data country ", this.mappingData['country']);
        for (var i=0;i<countrys.length;i++){
          this.tempcountrys.set(countrys[i]['id'],countrys[i]['name']);
        }
      });

    this.statesService
      .getStates()
      .subscribe(states => {
        this.searchMenus['state'] = states;
        for (var i=0;i<states.length;i++){
          this.tempstates.set(states[i]['id'],states[i]['name']);
        }
      },
        error =>{
          const dialogRef = this.dialog.open(CommonErrorDialog, {
            width: '500px',
            data: {error:error}
          });
          dialogRef.afterClosed().subscribe(result => {});
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
    if(this.isAllSelected() ){
      this.selection.clear() ;

    }
    else {
      this.dataSource.data.forEach(row => this.selection.select(row));
    }

    console.log("select ", this.selection);
  }

  changeOptions(event){
    if(this.selection.hasValue()) {
      this.isDisableDelete = false;
      this.deleteObjects= this.selection.selected;
    }else{
      this.isDisableDelete =true;
    }
  }
  //fetch general table info from database
  getCities(){
    this.cityService
      .getCities()
      .subscribe(cities => {
        this.cities = cities;
        console.log("get cities ", cities);
        this.dataSource = new MatTableDataSource<City>(cities);
        this.dataSource.paginator = this.generalPaginator;
        this.dataSource.sort = this.sort;
      });

    this.cityService
      .getCitiesFields()
      .subscribe(displayColumns => {
        this.displayedColumns = ['select'];
        this.displayedColumns = this.displayedColumns.concat(displayColumns);
        this.displayedColumns.push("update");
        this.displayedColumns.push("delete");

      })
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  //functions that click different dialog
  openAddDialog(): void {
    const dialogRef = this.dialog.open(CommonAddDialog, {
      width: '500px',
      data: {
        City : this.addCity,
        entityName   : 'City',
        fields : this.displayedColumns,
        searchMenus: this.searchMenus,
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add dialog was closed');
      if(result =='submit'){
        console.log('The element to be update ',this.addCity);

        this.cityService
          .createCity(this.addCity)
          .subscribe(data =>{
            this.getCities();
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

      this.addCity = new City();
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
        this.cityService.deleteCity(deleteId).subscribe( data=> {
          console.log(data);
          this.getCities();
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

  deletedSelectedObjects() {
    console.log("selected objects to be delete ", this.deleteObjects);
    var list = this.deleteObjects.map(objects=> {
      return objects.id
    });

    const dialogRef = this.dialog.open(CommonDeleteDialog, {
      width: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
        console.log('The add ialog was closed');
        // console.log(this.addHolidayLocalesDetail);
        if (result == 'submit') {
          this.cityService.deleteSelectedObjects(list)
            .subscribe(data => {
              this.selection.clear();
              this.isDisableDelete = true;
              this.getCities();
            })
          console.log("list ", list);
        } else {

        }
      },
      error =>{
        const dialogRef = this.dialog.open(CommonErrorDialog, {
          width: '500px',
          data: {
            error:error
          }
        });

        dialogRef.afterClosed().subscribe(result => {

        });

      }
    );
  }

  openUpdateDialog(city: any){
    var isByRow = false;
    if(city !== undefined) {
      console.log("the updateId is "+city.id);
      this.updateCity = city;
      isByRow = true;
    }
    else {
      console.log("general update");

    }
    const dialogRef = this.dialog.open(CommonUpdateDialog, {
      width: '500px',
      data: {
        updateCity: this.updateCity,
        entityName  :'updateCity',
        fields: this.displayedColumns,
        searchMenus: this.searchMenus,
        isByRow: isByRow
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The update dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if(result =='submit'){

        this.cityService
          .updateCity(this.updateCity.id, this.updateCity)
          .subscribe(data =>{
            this.getCities();
          },
            error =>{
              const dialogRef = this.dialog.open(CommonErrorDialog, {
                width: '500px',
                data: {error:error}
              });
              dialogRef.afterClosed().subscribe(result => {});
            })
        console.log("the element to be update ", this.updateCity);

      }else{

      }
      // initialized
      this.updateCity = new City();
    });
  }

  openSearchDialog(field: any, value: any): void {
    console.log("search ", field);
    console.log("value ", value);
    this.searchCity[field] = value;
    console.log("search obj ", this.searchCity);
    this.cityService
      .getSearchCities(this.searchCity)
      .subscribe(cities => {
        this.searchSource = new MatTableDataSource<City>(cities);
        this.isShowSearchTable= 'block';
        this.isShowGeneralTable = 'none';
        this.searchSource.paginator = this.searchPaginator;
        console.log("data source ",this.searchSource);
        //console.log(this.holidaysLocalesDetails[this.holidaysLocalesDetails.length-1].holiday);
        this.searchCity = new City();
      },
        error =>{
          const dialogRef = this.dialog.open(CommonErrorDialog, {
            width: '500px',
            data: {
              error:error
            }
          });
          dialogRef.afterClosed().subscribe(result => {
          });

        });

  }

  openAdvSearchDialog(){
    const dialogRef = this.dialog.open(CommonAdvSearchDialog, {
      width: '500px',
      data: {
        searchCity : this.searchCity,
        entityName :'searchCity',
        fields : this.displayedColumns,
        searchMenus: this.searchMenus
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The advance search dialog was closed', this.searchCity);

      if(result =='submit'){
        this.cityService
          .getSearchCities(this.searchCity)
          .subscribe(cities => {
            this.searchSource = new MatTableDataSource<City>(cities);
            this.isShowSearchTable= 'block';
            this.isShowGeneralTable = 'none';
            this.searchSource.paginator = this.searchPaginator;
            console.log("data source ",this.searchSource);
            //console.log(this.holidaysLocalesDetails[this.holidaysLocalesDetails.length-1].holiday);
            this.searchCity = new City();
          }
            ,
            error => {
              const dialogRef = this.dialog.open(CommonErrorDialog, {
                width: '500px',
                data: {
                  error:error
                }
              });

              dialogRef.afterClosed().subscribe(result => {

              });
              this.searchCity = new City();
            } );


      }else{

      }
    });
  }

  back(){
    this.isShowSearchTable = 'none';
    this.isShowGeneralTable = 'block';
  }

}
