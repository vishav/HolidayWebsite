import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {HinduLunar} from "../spring-calender-server";
import {HinduLunarService} from "../service/hindu-lunar.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hindu-lunar',
  templateUrl: './hindu-lunar.component.html',
  styleUrls: ['./hindu-lunar.component.css']
})
export class HinduLunarComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hindulunar : HinduLunar = new HinduLunar();

  searchMenus = {};
  constructor(private hinduLunarService : HinduLunarService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hinduLunarService;
    this.addObject = new HinduLunar();
    this.updateObject = new HinduLunar();
    this.entityName = 'HinduLunar';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}