import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {Islamic} from "../spring-calender-server";
import {IslamicService} from "../service/islamic.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-islamic',
  templateUrl: './islamic.component.html',
  styleUrls: ['./islamic.component.css']
})
export class IslamicComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  islamic : Islamic = new Islamic();

  searchMenus = {};
  constructor(private islamicService : IslamicService,
              dialog: MatDialog) {
    super(dialog);
    this.service = islamicService;
    this.addObject = new Islamic();
    this.updateObject = new Islamic();
    this.entityName = 'Islamic';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}