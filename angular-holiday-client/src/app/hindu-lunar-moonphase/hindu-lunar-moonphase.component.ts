import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {HinduLunarMoonphase} from "../spring-calender-server";
import {HinduLunarMoonphaseService} from "../service/hindu-lunar-moonphase.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hindu-lunar-moonphase',
  templateUrl: './hindu-lunar-moonphase.component.html',
  styleUrls: ['./hindu-lunar-moonphase.component.css']
})
export class HinduLunarMoonphaseComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hindulunarmoonphase : HinduLunarMoonphase = new HinduLunarMoonphase();

  searchMenus = {};
  constructor(private hinduLunarMoonphaseService : HinduLunarMoonphaseService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hinduLunarMoonphaseService;
    this.addObject = new HinduLunarMoonphase();
    this.updateObject = new HinduLunarMoonphase();
    this.entityName = 'HinduLunarMoonphase';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}