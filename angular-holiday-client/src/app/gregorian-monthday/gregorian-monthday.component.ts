import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {GregorianMonthday} from "../spring-calender-server";
import {GregorianMonthdayService} from "../service/gregorian-monthday.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-gregorian-monthday',
  templateUrl: './gregorian-monthday.component.html',
  styleUrls: ['./gregorian-monthday.component.css']
})
export class GregorianMonthdayComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  gregorianMonthday : GregorianMonthday = new GregorianMonthday();

  searchMenus = {};
  constructor(private gregorianMonthdayService : GregorianMonthdayService,
              dialog: MatDialog) {
    super(dialog);
    this.service = gregorianMonthdayService;
    this.addObject = new GregorianMonthday();
    this.updateObject = new GregorianMonthday();
    this.entityName = 'GregorianMonthday';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}

