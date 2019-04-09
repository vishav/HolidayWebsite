import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {Hebrew} from "../spring-calender-server";
import {HebrewService} from "../service/hebrew.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-hebrew',
  templateUrl: './hebrew.component.html',
  styleUrls: ['./hebrew.component.css']
})
export class HebrewComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  hebrew : Hebrew = new Hebrew();

  searchMenus = {};
  constructor(private hebrewService : HebrewService,
              dialog: MatDialog) {
    super(dialog);
    this.service = hebrewService;
    this.addObject = new Hebrew();
    this.updateObject = new Hebrew();
    this.entityName = 'Hebrew';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}