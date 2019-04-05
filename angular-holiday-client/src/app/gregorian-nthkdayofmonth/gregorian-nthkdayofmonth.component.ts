import { Component, OnInit } from '@angular/core';
import {GregorianNthkdayofmonthService} from "../service/gregorian-nthkdayofmonth.service";
import {CommonComponent} from "../common/common.component";
import {MatDialog} from "@angular/material";
import {GregorianNthkdayofmonth} from "../spring-calender-server";

@Component({
  selector: 'app-gregorian-nthkdayofmonth',
  templateUrl: './gregorian-nthkdayofmonth.component.html',
  styleUrls: ['./gregorian-nthkdayofmonth.component.css']
})
export class GregorianNthkdayofmonthComponent extends CommonComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  gregorianNthkdayofmonth : GregorianNthkdayofmonth = new GregorianNthkdayofmonth();
  searchMenus = {};
  constructor(private gregorianNthkdayofmonthService : GregorianNthkdayofmonthService,
              dialog: MatDialog) {
    super(dialog);
    this.service = gregorianNthkdayofmonthService;
    this.addObject = new GregorianNthkdayofmonth();
    this.updateObject = new GregorianNthkdayofmonth();
    this.entityName = 'GregorianNthkdayofmonth';
  }

  ngOnInit() {
    this.getTableInfo();
  }

}
