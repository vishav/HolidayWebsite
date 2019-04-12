import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {FormulaExtensions} from "../spring-calender-server";
import {FormulaExtensionsService} from "../service/formula-extensions.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-formula-extensions',
  templateUrl: './formula-extensions.component.html',
  styleUrls: ['./formula-extensions.component.css']
})
export class FormulaExtensionsComponent extends CommonComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  formulaExtensions : FormulaExtensions = new FormulaExtensions();

  searchMenus = {};

  constructor(private formulaExtensionsService: FormulaExtensionsService,
              dialog: MatDialog) {
    super(dialog);
    this.service = formulaExtensionsService;
    this.addObject = new FormulaExtensions();
    this.updateObject = new FormulaExtensions();
    this.entityName = 'FormulaExtensions';
  }

  ngOnInit() {
    this.getTableInfo();
  }

}