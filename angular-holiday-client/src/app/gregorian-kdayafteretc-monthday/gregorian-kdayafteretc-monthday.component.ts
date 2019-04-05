import { Component, OnInit } from '@angular/core';
import {GregorianKdayafteretcMonthday} from "../spring-calender-server";
import {CommonComponent} from "../common/common.component";
import {MatDialog} from "@angular/material";
import {GregorianKdayafteretcMonthdayService} from "../service/gregorian-kdayafteretc-monthday.service";

@Component({
  selector: 'app-gregorian-kdayafteretc-monthday',
  templateUrl: './gregorian-kdayafteretc-monthday.component.html',
  styleUrls: ['./gregorian-kdayafteretc-monthday.component.css']
})
export class GregorianKdayafteretcMonthdayComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  gregorianKdayafteretcMonthday : GregorianKdayafteretcMonthday = new GregorianKdayafteretcMonthday();
  searchMenus = {};

  constructor(private  gregorianKdayafteretcMonthdayService : GregorianKdayafteretcMonthdayService,
              dialog: MatDialog) {
    super(dialog);
    this.service =  gregorianKdayafteretcMonthdayService;
    this.addObject = new GregorianKdayafteretcMonthday();
    this.updateObject = new GregorianKdayafteretcMonthday();
    this.entityName = 'GregorianKdayafteretcMonthday';
  }
  ngOnInit() {
    this.getTableInfo();
  }

}
