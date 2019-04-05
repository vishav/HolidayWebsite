import { Component, OnInit } from '@angular/core';
import {GregorianMonthdayMoonphase} from "../spring-calender-server";
import {CommonComponent} from "../common/common.component";
import {GregorianMonthdayMoonphaseService} from "../service/gregorian-monthday-moonphase.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-gregorian-monthday-moonphase',
  templateUrl: './gregorian-monthday-moonphase.component.html',
  styleUrls: ['./gregorian-monthday-moonphase.component.css']
})
export class GregorianMonthdayMoonphaseComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  gregorianMonthdayMoonphase : GregorianMonthdayMoonphase = new GregorianMonthdayMoonphase();

  searchMenus = {};
  constructor(private gregorianMonthdayMoonphaseService : GregorianMonthdayMoonphaseService,
              dialog: MatDialog) {
    super(dialog);
    this.service = gregorianMonthdayMoonphaseService;
    this.addObject = new GregorianMonthdayMoonphase();
    this.updateObject = new GregorianMonthdayMoonphase();
    this.entityName = 'GregorianMonthdayMoonphase';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}
