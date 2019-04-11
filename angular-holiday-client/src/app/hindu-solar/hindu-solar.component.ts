import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {HinduSolar} from "../spring-calender-server";
import {HinduSolarService} from "../service/hindu-solar.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hindu-solar',
  templateUrl: './hindu-solar.component.html',
  styleUrls: ['./hindu-solar.component.css']
})
export class HinduSolarComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hindusolar : HinduSolar = new HinduSolar();

  searchMenus = {};
  constructor(private hinduSolarService : HinduSolarService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hinduSolarService;
    this.addObject = new HinduSolar();
    this.updateObject = new HinduSolar();
    this.entityName = 'HinduSolar';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}