import {Component, OnInit, ViewChild} from '@angular/core';
import {Observable} from "rxjs";
import {HolidayNotes} from "../spring-calender-server";
import {SelectionModel} from "@angular/cdk/collections";
import {MatTableDataSource, MatDialog} from "@angular/material";
import {CommonComponent} from "../common/common.component";
import {HolidayNotesService} from "../service/holiday-notes.service";

@Component({
  selector: 'app-holiday-notes',
  templateUrl: './holiday-notes.component.html',
  styleUrls: ['./holiday-notes.component.css']
})
export class HolidayNotesComponent extends CommonComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  holidayNotes : HolidayNotes = new HolidayNotes();

  searchMenus = {};

  constructor(private holidayNotesService: HolidayNotesService,
              dialog: MatDialog) {
    super(dialog);
    this.service = holidayNotesService;
    this.addObject = new HolidayNotes();
    this.updateObject = new HolidayNotes();
    this.entityName = 'HolidayNotes';
  }


  ngOnInit() {
    this.getTableInfo();
  }

  //fetch general table info from database
  /*
  getHolidayNoteses(){
    this.holidayNotesService
      .getAll()
      .subscribe(holidayNoteses => {
        this.holidayNoteses = holidayNoteses;
        console.log("get holidayNoteses ", holidayNoteses);
        this.dataSource = new MatTableDataSource<HolidayNotes>(holidayNoteses);
        this.dataSource.paginator = this.generalPaginator;
        this.dataSource.sort = this.sort;
      });

    this.holidayNotesService
      .getFields()
      .subscribe(displayColumns => {
        this.displayedColumns = ['select'];
        this.displayedColumns = this.displayedColumns.concat(displayColumns);
        this.displayedColumns.push("update");
        this.displayedColumns.push("delete");
        //this.displayedColumns.push("select");

      })
  }
 */


}
