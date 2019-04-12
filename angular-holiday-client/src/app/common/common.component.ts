import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort, MatPaginator, MatTableDataSource, MatDialog} from "@angular/material";
import {SelectionModel} from "@angular/cdk/collections";
import {
  CommonAddDialog, CommonUpdateDialog, CommonDeleteDialog, CommonErrorDialog,
  CommonAdvSearchDialog
} from "../common-dialog/common-component";
import {
  HolidayNotes, FormulaNotes, ConcernsQuestions, GregorianMonthdayMoonphase,
  GregorianMonthday, GregorianKdayafteretcMonthday, GregorianMonthdaySpecial, 
  GregorianNthkdayofmonth, Chinese, EcclesiasticalGregorian, EcclesiasticalOrthodox,
  Hebrew, HebrewSpecial, HinduLunar, HinduLunarMoonphase, HinduLunarSpecial, OldHinduLunar,
  OldHinduLunarMoonphase, OldHinduLunarSpecial, HinduSolar,
  HinduSolarSpecial, Islamic, IslamicSpecial, Regions
} from "../spring-calender-server";


@Component({
  selector: 'app-common',
  templateUrl: './common.component.html',
  styleUrls: ['./common.component.css']
})
export class CommonComponent implements OnInit {

  deleteObjects: any;
  addObject :any;
  updateObject: any;
  deleteObject: any;
  searchObject: any;
  object: any;


  entityName : any;

  dataSource: MatTableDataSource<any>;
  searchSource: MatTableDataSource<any>;
  searchMenus = {};

  displayedColumns : string[] = ['select'];

  selection = new SelectionModel<any>(true, []);

  isShowSearchTable= 'none';
  isShowGeneralTable = 'block';

  isDisableDelete = true;

  infoList: any;
  service: any;

  //useful component for table representation
  @ViewChild('scheduledOrdersPaginator') generalPaginator: MatPaginator;
  @ViewChild('searchPaginator') searchPaginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private dialog: MatDialog) { }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit() {
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
  getTableInfo(){
    this.service
      .getAll()
      .subscribe(info => {
        this.infoList = info;
        console.log("get table info", info);
        this.dataSource = new MatTableDataSource<any>(info);
        this.dataSource.paginator = this.generalPaginator;
        this.dataSource.sort = this.sort;
      });

   this.service
      .getFields()
      .subscribe(displayColumns => {
        console.log("get fields", displayColumns);
        this.displayedColumns = ['select'];
        this.displayedColumns = this.displayedColumns.concat(displayColumns);
        this.displayedColumns.push("update");
        this.displayedColumns.push("delete");
      })
    this.refresh();
  }

  openAddDialog(){
    const dialogRef = this.dialog.open(CommonAddDialog, {
      width: '500px',
      data: {
        addObject : this.addObject,
        entityName   : 'addObject',
        fields : this.displayedColumns,
        //searchMenus: this.searchMenus,
      }
    });

    dialogRef.afterClosed().subscribe(result => {

      console.log('The add dialog was closed');
      if(result =='submit'){
        this.service
          .create(this.addObject)
          .subscribe(data=>{
            console.log(data);
            this.refresh();
            this.getTableInfo();

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

          })
      }else{

      }
    });
  }

  openUpdateDialog(object: any){
    var isByRow = false;
    if(object !== undefined) {
      console.log("the updateId is "+object.id);
      this.updateObject = object;
      isByRow = true;
    }
    else {
      console.log("general update");

    }
    const dialogRef = this.dialog.open(CommonUpdateDialog, {
      width: '500px',
      data: {
        updateObject: this.updateObject,
        entityName  :'updateObject',
        fields: this.displayedColumns,
        isByRow: isByRow
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The update dialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if(result =='submit'){

        this.service.update(this.updateObject.id, this.updateObject).subscribe(data=> {
          console.log(data);
          this.refresh();
          this.getTableInfo();


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
        console.log("the element to be update ", this.updateObject);

      }else{

      }
      // initialized
      this.refresh();
    });
  }

  openDeleteDialog(deleteId: number){
    console.log("the deleteId is "+deleteId)
    const dialogRef = this.dialog.open(CommonDeleteDialog, {
      width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The delete dialog was closed');
      if(result =='submit'){
        this.service.delete(deleteId).subscribe( data=> {
          console.log(data);

          this.refresh();
          this.getTableInfo();
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
        this.service.deleteSelectedObjects(list)
          .subscribe(data => {
            this.selection.clear();
            this.isDisableDelete = true;
            this.refresh();
            this.getTableInfo();

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
  openSearchDialog(){
    const dialogRef = this.dialog.open(CommonAdvSearchDialog, {
      width: '500px',
      data: {
        searchObject: this.searchObject,
        entityName  :'searchObject',
        fields: this.displayedColumns,
        searchMenus: this.searchMenus
      }
    });

    dialogRef.afterClosed().subscribe(result => {

      if(result =='submit'){
        this.service
          .getSearch(this.searchObject)
          .subscribe(searchResult => {
            this.searchSource = new MatTableDataSource<any>(searchResult);
            this.isShowSearchTable= 'block';
            this.isShowGeneralTable = 'none';
            this.searchSource.paginator = this.searchPaginator;
            this.refresh();
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
    this.selection.clear();
    switch(this.entityName){
      case "HolidayNotes":
        this.addObject = new HolidayNotes();
        this.deleteObject = new HolidayNotes();
        this.updateObject = new HolidayNotes();
        this.searchObject = new HolidayNotes();
        this.deleteObjects = [];
            break;
      case "FormulaNotes":
        this.addObject = new FormulaNotes();
        this.deleteObject = new FormulaNotes();
        this.updateObject = new FormulaNotes();
        this.searchObject = new FormulaNotes();
        this.deleteObjects = [];
            break;
      case "ConcernsQuestions":
        this.addObject = new ConcernsQuestions();
        this.deleteObject = new ConcernsQuestions();
        this.updateObject = new ConcernsQuestions();
        this.searchObject = new ConcernsQuestions();
        this.deleteObjects = [];
            break;
      case "GregorianMonthdayMoonphase":
        this.deleteObjects = new GregorianMonthdayMoonphase();
        this.addObject = new GregorianMonthdayMoonphase();
        this.updateObject = new GregorianMonthdayMoonphase();
        this.searchObject =new GregorianMonthdayMoonphase();

        this.deleteObjects = [];
            break;
      case "GregorianMonthday":
        this.deleteObjects = new GregorianMonthday();
        this.addObject = new GregorianMonthday();
        this.updateObject = new GregorianMonthday();
        this.searchObject = new GregorianMonthday();
        this.deleteObjects = [];
        break;
      case "GregorianKdayafteretcMonthday":
        this.deleteObjects = new GregorianKdayafteretcMonthday();
        this.addObject = new GregorianKdayafteretcMonthday();
        this.updateObject = new GregorianKdayafteretcMonthday();
        this.searchObject = new GregorianMonthday();
        this.deleteObjects = [];
        break;
      case "GregorianMonthdaySpecial":
        this.deleteObjects = new GregorianMonthdaySpecial();
        this.addObject = new GregorianMonthdaySpecial();
        this.updateObject = new GregorianMonthdaySpecial();
        this.searchObject = new GregorianMonthdaySpecial();
          this.deleteObjects = [];
        break;
      case "GregorianNthkdayofmonth":
        this.deleteObjects = new GregorianNthkdayofmonth();
        this.addObject = new GregorianNthkdayofmonth();
        this.updateObject = new GregorianNthkdayofmonth();
        this.searchObject = new GregorianNthkdayofmonth();
        this.deleteObjects = [];
      case "Chinese":
        this.deleteObjects = new Chinese();
        this.addObject = new Chinese();
        this.updateObject = new Chinese();
        this.searchObject = new Chinese();
        this.deleteObjects = [];
      case "EcclesiasticalGregorian":
        this.deleteObjects = new EcclesiasticalGregorian();
        this.addObject = new EcclesiasticalGregorian();
        this.updateObject = new EcclesiasticalGregorian();
        this.searchObject = new EcclesiasticalGregorian();
        this.deleteObjects = [];
      case "EcclesiasticalOrthodox":
        this.deleteObjects = new EcclesiasticalOrthodox();
        this.addObject = new EcclesiasticalOrthodox();
        this.updateObject = new EcclesiasticalOrthodox();
        this.searchObject = new EcclesiasticalOrthodox();
        this.deleteObjects = [];
      case "Hebrew":
        this.deleteObjects = new Hebrew();
        this.addObject = new Hebrew();
        this.updateObject = new Hebrew();
        this.searchObject = new Hebrew();
        this.deleteObjects = [];
      case "HebrewSpecial":
        this.deleteObjects = new HebrewSpecial();
        this.addObject = new HebrewSpecial();
        this.updateObject = new HebrewSpecial();
        this.searchObject = new HebrewSpecial();
        this.deleteObjects = [];
      case "HinduLunar":
        this.deleteObjects = new HinduLunar();
        this.addObject = new HinduLunar();
        this.updateObject = new HinduLunar();
        this.searchObject = new HinduLunar();
        this.deleteObjects = [];
      case "HinduLunarMoonphase":
        this.deleteObjects = new HinduLunarMoonphase();
        this.addObject = new HinduLunarMoonphase();
        this.updateObject = new HinduLunarMoonphase();
        this.searchObject = new HinduLunarMoonphase();
        this.deleteObjects = [];
      case "HinduLunarSpecial":
        this.deleteObjects = new HinduLunarSpecial();
        this.addObject = new HinduLunarSpecial();
        this.updateObject = new HinduLunarSpecial();
        this.searchObject = new HinduLunarSpecial();
        this.deleteObjects = [];
      case "OldHinduLunar":
        this.deleteObjects = new OldHinduLunar();
        this.addObject = new OldHinduLunar();
        this.updateObject = new OldHinduLunar();
        this.searchObject = new OldHinduLunar();
        this.deleteObjects = [];
      case "OldHinduLunarMoonphase":
        this.deleteObjects = new OldHinduLunarMoonphase();
        this.addObject = new OldHinduLunarMoonphase();
        this.updateObject = new OldHinduLunarMoonphase();
        this.searchObject = new OldHinduLunarMoonphase();
        this.deleteObjects = [];
      case "OldHinduLunarSpecial":
        this.deleteObjects = new OldHinduLunarSpecial();
        this.addObject = new OldHinduLunarSpecial();
        this.updateObject = new OldHinduLunarSpecial();
        this.searchObject = new OldHinduLunarSpecial();
        this.deleteObjects = [];
      case "HinduSolar":
        this.deleteObjects = new HinduSolar();
        this.addObject = new HinduSolar();
        this.updateObject = new HinduSolar();
        this.searchObject = new HinduSolar();
        this.deleteObjects = [];
      case "HinduSolarSpecial":
        this.deleteObjects = new HinduSolarSpecial();
        this.addObject = new HinduSolarSpecial();
        this.updateObject = new HinduSolarSpecial();
        this.searchObject = new HinduSolarSpecial();
        this.deleteObjects = [];
      case "Islamic":
        this.deleteObjects = new Islamic();
        this.addObject = new Islamic();
        this.updateObject = new Islamic();
        this.searchObject = new Islamic();
        this.deleteObjects = [];
      case "IslamicSpecial":
        this.deleteObjects = new IslamicSpecial();
        this.addObject = new IslamicSpecial();
        this.updateObject = new IslamicSpecial();
        this.searchObject = new IslamicSpecial();
        this.deleteObjects = [];
      case "Regions":
        this.deleteObjects = new Regions();
        this.addObject = new Regions();
        this.updateObject = new Regions();
        this.searchObject = new Regions();
        this.deleteObjects = [];
        break;
      default:
    }
  }

}
