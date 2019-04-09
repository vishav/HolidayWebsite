import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {Chinese} from "../spring-calender-server";
import {ChineseService} from "../service/chinese.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-chinese',
  templateUrl: './chinese.component.html',
  styleUrls: ['./chinese.component.css']
})
export class ChineseComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  chinese : Chinese = new Chinese();

  searchMenus = {};
  constructor(private chineseService : ChineseService,
              dialog: MatDialog) {
    super(dialog);
    this.service = chineseService;
    this.addObject = new Chinese();
    this.updateObject = new Chinese();
    this.entityName = 'Chinese';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}
