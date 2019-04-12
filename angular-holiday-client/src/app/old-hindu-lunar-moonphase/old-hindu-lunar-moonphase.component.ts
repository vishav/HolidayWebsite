import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {OldHinduLunarMoonphase} from "../spring-calender-server";
import {OldHinduLunarMoonphaseService} from "../service/old-hindu-lunar-moonphase.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-old-hindu-lunar-moonphase',
  templateUrl: './old-hindu-lunar-moonphase.component.html',
  styleUrls: ['./old-hindu-lunar-moonphase.component.css']
})
export class OldHinduLunarMoonphaseComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  oldhindulunarmoonphase : OldHinduLunarMoonphase = new OldHinduLunarMoonphase();

  searchMenus = {};
  constructor(private oldHinduLunarMoonphaseService : OldHinduLunarMoonphaseService,
              dialog: MatDialog) {
    super(dialog);
    this.service = oldHinduLunarMoonphaseService;
    this.addObject = new OldHinduLunarMoonphase();
    this.updateObject = new OldHinduLunarMoonphase();
    this.entityName = 'OldHinduLunarMoonphase';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}