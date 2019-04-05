import {Component, OnInit, Inject, ChangeDetectorRef, ViewChild, AfterViewInit} from '@angular/core';
import {Holiday} from '../../spring-calender-server';
import {HolidaysService} from '../../service/holidays.service';
import {MatPaginator, MatTableDataSource, MAT_DIALOG_DATA, MatDialogRef, MatDialog, MatSort} from "@angular/material";
import {Observable} from "rxjs";
import {SelectionModel} from "@angular/cdk/collections";
import {
  CommonAddDialog, CommonUpdateDialog, CommonAdvSearchDialog,
  CommonErrorDialog
} from "../../common-dialog/common-component";

@Component({
  selector: 'app-edit-holidays',
  templateUrl: './edit-holidays.component.html',
  styleUrls: ['./edit-holidays.component.css']
})

export class EditHolidaysComponent implements OnInit {


  name: string;
  holidays: Observable<Holiday[]>;
  holidaysFields: Observable<string[]>;
  displayedColumns: string[] = ['select', 'id', 'name', 'delete', 'update'];

  holidaySource: MatTableDataSource<any>;
  searchSource: MatTableDataSource<any>;
  isShowSearchTable= 'none';
  isShowGeneralTable = 'block';
  selection = new SelectionModel<Holiday>(true, []);
  /*
  addDisplay = 'none';
  updateDisplay = 'none';
  removeDisplay = 'none';
  */
  deleteHolidays: Holiday[];

  isDisableDelete = true;

  listmap = new Map([
    ["addDisplay", 'none'],
    ["updateDisplay", 'none'],
    ["removeDisplay", 'none'],
    ["searchDisplay", 'none'],
  ]);

  searchMenus = {};
  holiday: Holiday = new Holiday();
  updateHoliday: Holiday = new Holiday();
  addHoliday: Holiday = new Holiday();
  addSubmitted = false;
  removeSubmitted = false;
  updateSubmitted = false;


  constructor(private holidaysService: HolidaysService,
              public dialog: MatDialog) {

  }

  @ViewChild('scheduledOrdersPaginator') paginator: MatPaginator;
  @ViewChild('searchPaginator') searchPaginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  getHolidays(): void {
    //Subscribe in HolidaysComponent
    console.log("before getting the data ", this.holidays)
    this.holidaysService
      .getHolidays()
      .subscribe(holidays => {
        this.holidays = holidays;
        this.holidaySource = new MatTableDataSource<Holiday>(holidays);
        this.holidaySource.paginator = this.paginator;
        this.holidaySource.sort = this.sort;

      });

    this.holidaysService
      .getHolidaysFields()
      .subscribe(holidaysFields => {
        this.holidaysFields = holidaysFields;
      })
    this.refresh();
  }


  ngOnInit() {
    this.getHolidays();
  }


  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.holidaySource.data.length;
    //console.log("number of selected row ",numRows);
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    if (this.isAllSelected()) {
      this.selection.clear();
    }
    else {
      this.holidaySource.data.forEach(row => this.selection.select(row));
    }
  }

  openDeleteDialog(deleteId: number) {
    console.log("the deleid is " + deleteId)
    const dialogRef = this.dialog.open(DeleteDialog, {
      width: '500px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add ialog was closed');
      // console.log(this.addHolidayLocalesDetail);
      if (result == 'submit') {
        this.holidaysService.deleteHoliday(deleteId)
          .subscribe(data =>{
            this.selection.clear();
            this.getHolidays();
            this.refresh();
          })

      } else {
        this.refresh();
      }
    });
  }

  openUpdateDialog(updateHoliday: Holiday) {
    var isByRow = false;
    if(updateHoliday!==undefined &&  updateHoliday.id !==undefined) {
      console.log("the update is " + updateHoliday.id)
      this.updateHoliday = updateHoliday;
      isByRow = true;
    }
    const dialogRef = this.dialog.open(CommonUpdateDialog, {
      width: '500px',
      data: {
        holiday: this.updateHoliday,
        entityName  :'holiday',
        fields: this.holidaysFields,
        isByRow: isByRow
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add ialog was closed');
      //    console.log(this.addHolidayLocalesDetail);
      if (result == 'submit') {
        this.holidaysService.updateHoliday(this.updateHoliday.id, this.updateHoliday)
          .subscribe(data =>{
            this.selection.clear();
            this.getHolidays();
            this.refresh();
          },
            error =>{
              if(error.status == 404){
                error = "Fail to found the element you want to update";
              }
              console.log("error", error);
              const dialogRef = this.dialog.open(CommonErrorDialog, {
                width: '500px',
                data: {error:error}
              });
              dialogRef.afterClosed().subscribe(result => {});
            })

      } else {
        this.refresh();
      }
    });
  }

  openAddDialog(holiday: any) {
    if(holiday!==undefined &&  holiday.id !==undefined) {
      console.log("the update is " + holiday.id)
      this.addHoliday = holiday;
    }
    const dialogRef = this.dialog.open(CommonAddDialog, {
      width: '500px',
      data: {
        holiday: this.addHoliday,
        entityName:'holiday',
        fields: this.holidaysFields,

      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The add dialog was closed');
      if (result == 'submit') {

        this.holidaysService.createHoliday(this.addHoliday)
          .subscribe(data => {
              console.log(data);
              this.getHolidays();
              this.refresh();
            }
            , error => console.log(error));
      } else {

      }
    });
  }

  changeOptions(event) {

    console.log("selection len", this.selection);

    console.log("change has value ", this.selection.hasValue());
    console.log("Selected ", this.selection);
    if (this.selection.hasValue()) {
      this.isDisableDelete = false;
      this.deleteHolidays = this.selection.selected;
    } else {
      this.isDisableDelete = true;
    }
  }

  deletedSelectedHolidays() {
    console.log("holiday to be delete ", this.deleteHolidays);
    var list = this.deleteHolidays.map(holidays=> {
      return holidays.id
    });

    this.holidaysService.deleteSelectedHoliday(list)
      .subscribe(data => {
        this.getHolidays();
        this.selection.clear();
        this.isDisableDelete = true;
        this.refresh();
      })
    console.log("list ", list);
  }

  applyFilter(filterValue: string) {
    this.holidaySource.filter = filterValue.trim().toLowerCase();
  }

  openSearchDialog(){
    const dialogRef = this.dialog.open(CommonAdvSearchDialog, {
      width: '500px',
      data: {
        holiday: this.holiday,
        entityName  :'holiday',
        fields: this.displayedColumns,
        searchMenus: this.searchMenus
      }
    });

    dialogRef.afterClosed().subscribe(result => {

      console.log(this.holiday);
      if(result =='submit'){
        this.holidaysService
        .getSearch(this.holiday)
          .subscribe(searchResult => {
            this.searchSource = new MatTableDataSource<Holiday>(searchResult);
            this.isShowSearchTable= 'block';
            this.isShowGeneralTable = 'none';
            this.searchSource.paginator = this.searchPaginator;
            this.refresh();
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
    this.holiday =  new Holiday();
    this.updateHoliday =new Holiday();
    this.addHoliday = new Holiday();
  }

}
@Component({
  selector: 'holidays-update-dialog',
  templateUrl: 'holidays-update-dialog.html',
})
export class  UpdateDialog {

  constructor(public dialogRef: MatDialogRef<UpdateDialog>,
  @Inject(MAT_DIALOG_DATA) public data: Holiday,
  @Inject(MAT_DIALOG_DATA) public fields: string[]){}


  onNoClick(): void {
    console.log("cancel update", this.data);
    this.dialogRef.close("cancel");
  }

  onUpdateClick(): void {
    console.log("on submit click");
    this.dialogRef.close("submit");
  }

}


@Component({
  selector: 'holidays-delete-dialog',
  templateUrl: 'delete-dialog.html',
})
  export class  DeleteDialog {

  constructor(public dialogRef: MatDialogRef<DeleteDialog>,
    @Inject(MAT_DIALOG_DATA) public holiday: Holiday,
    @Inject(MAT_DIALOG_DATA) public fields: string[]){}


  onNoClick(): void {
    console.log("cancel delete");
    this.dialogRef.close("cancel");
  }

  onDeleteClick(): void {
    console.log("on submit click" );
    this.dialogRef.close("submit");
  }

}
