import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {OldHinduLunarSpecial} from "../spring-calender-server";
import {OldHinduLunarSpecialService} from "../service/old-hindu-lunar-special.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-old-hindu-lunar-special',
  templateUrl: './old-hindu-lunar-special.component.html',
  styleUrls: ['./old-hindu-lunar-special.component.css']
})
export class OldHinduLunarSpecialComponent extends CommonComponent implements OnInit {

  //members-------------------------------------------------------------------------------------------------------------
  oldhindulunarspecial : OldHinduLunarSpecial = new OldHinduLunarSpecial();

  searchMenus = {};
  constructor(private oldHinduLunarSpecialService : OldHinduLunarSpecialService,
              dialog: MatDialog) {
    super(dialog);
    this.service = oldHinduLunarSpecialService;
    this.addObject = new OldHinduLunarSpecial();
    this.updateObject = new OldHinduLunarSpecial();
    this.entityName = 'OldHinduLunarSpecial';

  }

  ngOnInit() {
    this.getTableInfo();
  }

}