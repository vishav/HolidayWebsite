import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {HebrewSpecial} from "../spring-calender-server";
import {HebrewSpecialService} from "../service/hebrew-special.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hebrew-special',
  templateUrl: './hebrew-special.component.html',
  styleUrls: ['./hebrew-special.component.css']
})
export class HebrewSpecialComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hebrewspecial : HebrewSpecial = new HebrewSpecial();

  searchMenus = {};
  constructor(private hebrewSpecialService : HebrewSpecialService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hebrewSpecialService;
    this.addObject = new HebrewSpecial();
    this.updateObject = new HebrewSpecial();
    this.entityName = 'HebrewSpecial';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}