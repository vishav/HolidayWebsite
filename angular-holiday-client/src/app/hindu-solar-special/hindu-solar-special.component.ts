import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {HinduSolarSpecial} from "../spring-calender-server";
import {HinduSolarSpecialService} from "../service/hindu-solar-special.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hindu-solar-special',
  templateUrl: './hindu-solar-special.component.html',
  styleUrls: ['./hindu-solar-special.component.css']
})
export class HinduSolarSpecialComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hindusolarspecial : HinduSolarSpecial = new HinduSolarSpecial();

  searchMenus = {};
  constructor(private hinduSolarSpecialService : HinduSolarSpecialService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hinduSolarSpecialService;
    this.addObject = new HinduSolarSpecial();
    this.updateObject = new HinduSolarSpecial();
    this.entityName = 'HinduSolarSpecial';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}