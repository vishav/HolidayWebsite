import { Component, OnInit } from '@angular/core';
import {CommonComponent} from "../common/common.component";
import {FormulaNotes} from "../spring-calender-server";
import {FormulaNotesService} from "../service/formula-notes.service";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-formula-notes',
  templateUrl: './formula-notes.component.html',
  styleUrls: ['./formula-notes.component.css']
})
export class FormulaNotesComponent extends CommonComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  formulaNotes : FormulaNotes = new FormulaNotes();

  searchMenus = {};

  constructor(private formulaNotesService: FormulaNotesService,
              dialog: MatDialog) {
    super(dialog);
    this.service = formulaNotesService;
    this.addObject = new FormulaNotes();
    this.updateObject = new FormulaNotes();
    this.entityName = 'FormulaNotes';
  }

  ngOnInit() {
    this.getTableInfo();
  }

}
