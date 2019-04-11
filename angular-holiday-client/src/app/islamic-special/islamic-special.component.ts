import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {IslamicSpecial} from "../spring-calender-server";
import {IslamicSpecialService} from "../service/islamic-special.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-islamic-special',
  templateUrl: './islamic-special.component.html',
  styleUrls: ['./islamic-special.component.css']
})
export class IslamicSpecialComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  islamicspecial : IslamicSpecial = new IslamicSpecial();

  searchMenus = {};
  constructor(private islamicSpecialService : IslamicSpecialService,
              dialog: MatDialog) {
    super(dialog);
    this.service = islamicSpecialService;
    this.addObject = new IslamicSpecial();
    this.updateObject = new IslamicSpecial();
    this.entityName = 'IslamicSpecial';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}