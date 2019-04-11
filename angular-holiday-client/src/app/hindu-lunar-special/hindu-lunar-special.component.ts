import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {HinduLunarSpecial} from "../spring-calender-server";
import {HinduLunarSpecialService} from "../service/hindu-lunar-special.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hindu-lunar-special',
  templateUrl: './hindu-lunar-special.component.html',
  styleUrls: ['./hindu-lunar-special.component.css']
})
export class HinduLunarSpecialComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hindulunarspecial : HinduLunarSpecial = new HinduLunarSpecial();

  searchMenus = {};
  constructor(private hinduLunarSpecialService : HinduLunarSpecialService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hinduLunarSpecialService;
    this.addObject = new HinduLunarSpecial();
    this.updateObject = new HinduLunarSpecial();
    this.entityName = 'HinduLunarSpecial';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}