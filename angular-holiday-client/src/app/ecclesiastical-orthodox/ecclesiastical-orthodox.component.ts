import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {EcclesiasticalOrthodox} from "../spring-calender-server";
import {EcclesiasticalOrthodoxService} from "../service/ecclesiastical-orthodox.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-ecclesiastical-orthodox',
  templateUrl: './ecclesiastical-orthodox.component.html',
  styleUrls: ['./ecclesiastical-orthodox.component.css']
})
export class EcclesiasticalOrthodoxComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  ecclesiasticalorthodox : EcclesiasticalOrthodox = new EcclesiasticalOrthodox();

  searchMenus = {};
  constructor(private ecclesiasticalorthodoxService : EcclesiasticalOrthodoxService,
              dialog: MatDialog) {
    super(dialog);
    this.service = ecclesiasticalorthodoxService;
    this.addObject = new EcclesiasticalOrthodox();
    this.updateObject = new EcclesiasticalOrthodox();
    this.entityName = 'EcclesiasticalOrthodox';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}