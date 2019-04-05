import {Component, OnInit, ViewChild} from '@angular/core';
import {Holiday} from '../../spring-calender-server';
import {HolidaysService} from '../../service/holidays.service';
import {MatPaginator, MatTableDataSource} from "@angular/material";
import {Observable} from "rxjs";
@Component({
  selector: 'app-show-holidays',
  templateUrl: './show-holidays.component.html',
  styleUrls: ['./show-holidays.component.css']
})
export class ShowHolidaysComponent implements OnInit {
  holidays : Observable<Holiday[]>;
  displayedColumns: string[] = ['position', 'name' ];
  //holidaySource = new MatTableDataSource<Holiday>(ELEMENT_DATA);
  holidaySource : MatTableDataSource<Holiday>;
  holidaysFields : Observable<string[]>;

  constructor(private holidaysService : HolidaysService) { }
  getHolidays(): void {
    //Subscribe in HolidaysComponent
    this.holidaysService
      .getHolidays()
      .subscribe(holidays => {
        this.holidays = holidays;
        this.holidaySource = new MatTableDataSource<Holiday>(holidays);
      });

    this.holidaysService
      .getHolidaysFields()
      .subscribe(holidaysFields => {
        this.holidaysFields = holidaysFields;
        /*
        this.holidaysFields.forEach((value: string) => {
          console.log("holiday field "+ value);
        } ) */
      })
  }
  ngOnInit() {
    this.reloadData();
  }


  reloadData(){
    this.holidaysService
      .getHolidays()
      .subscribe(holidays => {
        this.holidays = holidays;
        this.holidaySource = new MatTableDataSource<Holiday>(holidays);
      });

    this.holidaysService
      .getHolidaysFields()
      .subscribe(holidaysFields => {
        this.holidaysFields = holidaysFields;
        /*
        this.holidaysFields.forEach((value: string) => {
          console.log("holiday field "+ value);
        } ) */
      })
  }
}
