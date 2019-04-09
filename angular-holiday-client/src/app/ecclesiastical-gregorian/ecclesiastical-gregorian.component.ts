import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {EcclesiasticalGregorian} from "../spring-calender-server";
import {EcclesiasticalGregorianService} from "../service/ecclesiastical-gregorian.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-ecclesiastical-gregorian',
  templateUrl: './ecclesiastical-gregorian.component.html',
  styleUrls: ['./ecclesiastical-gregorian.component.css']
})
export class EcclesiasticalGregorianComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  ecclesiasticalgregorian : EcclesiasticalGregorian = new EcclesiasticalGregorian();

  searchMenus = {};
  constructor(private ecclesiasticalgregorianService : EcclesiasticalGregorianService,
              dialog: MatDialog) {
    super(dialog);
    this.service = ecclesiasticalgregorianService;
    this.addObject = new EcclesiasticalGregorian();
    this.updateObject = new EcclesiasticalGregorian();
    this.entityName = 'EcclesiasticalGregorian';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}
