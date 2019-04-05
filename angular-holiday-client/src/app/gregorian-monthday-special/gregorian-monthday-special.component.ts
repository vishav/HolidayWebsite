import { Component, OnInit } from '@angular/core';
import {GregorianMonthdaySpecial} from "../spring-calender-server";
import {GregorianMonthdaySpecialService} from "../service/gregorian-monthday-special.service";
import {MatDialog} from "@angular/material";
import {CommonComponent} from "../common/common.component";

@Component({
  selector: 'app-gregorian-monthday-special',
  templateUrl: './gregorian-monthday-special.component.html',
  styleUrls: ['./gregorian-monthday-special.component.css']
})
export class GregorianMonthdaySpecialComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  gregorianMonthdaySpecial : GregorianMonthdaySpecial = new GregorianMonthdaySpecial();
  constructor(private gregorianMonthdaySpecialService : GregorianMonthdaySpecialService,
              dialog: MatDialog) {
    super(dialog);
    this.service = gregorianMonthdaySpecialService;
    this.addObject = new GregorianMonthdaySpecial();
    this.updateObject = new GregorianMonthdaySpecial();
    this.entityName = 'GregorianMonthdaySpecial';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}
