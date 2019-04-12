import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {OldHinduLunar} from "../spring-calender-server";
import {OldHinduLunarService} from "../service/old-hindu-lunar.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-old-hindu-lunar',
  templateUrl: './old-hindu-lunar.component.html',
  styleUrls: ['./old-hindu-lunar.component.css']
})

export class OldHinduLunarComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  oldhindulunar : OldHinduLunar = new OldHinduLunar();

  searchMenus = {};
  constructor(private oldHinduLunarService : OldHinduLunarService,
              dialog: MatDialog) {
    super(dialog);
    this.service = oldHinduLunarService;
    this.addObject = new OldHinduLunar();
    this.updateObject = new OldHinduLunar();
    this.entityName = 'OldHinduLunar';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}
