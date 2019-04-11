import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {Regions} from "../spring-calender-server";
import {RegionsService} from "../service/regions.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-regions',
  templateUrl: './regions.component.html',
  styleUrls: ['./regions.component.css']
})
export class RegionsComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  regions : Regions = new Regions();

  searchMenus = {};
  constructor(private regionsService : RegionsService,
              dialog: MatDialog) {
    super(dialog);
    this.service = regionsService;
    this.addObject = new Regions();
    this.updateObject = new Regions();
    this.entityName = 'Regions';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}