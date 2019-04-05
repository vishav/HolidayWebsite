import {Component, OnInit, ViewChild} from '@angular/core';
import {Observable} from "rxjs";
import {ConcernsQuestions, HolidayNotes} from "../spring-calender-server";
import {SelectionModel} from "@angular/cdk/collections";
import {MatTableDataSource, MatDialog} from "@angular/material";
import {CommonComponent} from "../common/common.component";
import {ConcernQuestionsService} from "../service/concerns-questions.service";


@Component({
  selector: 'app-concerns-questions',
  templateUrl: './concerns-questions.component.html',
  styleUrls: ['./concerns-questions.component.css']
})
export class ConcernsQuestionsComponent extends CommonComponent implements OnInit {
  //members-------------------------------------------------------------------------------------------------------------
  concernQuestions : ConcernsQuestions = new ConcernsQuestions();

  searchMenus = {};

  constructor(private concernQuestionsService: ConcernQuestionsService,
              dialog: MatDialog) {
    super(dialog);
    this.service = concernQuestionsService;
    this.addObject = new ConcernsQuestions();
    this.updateObject = new ConcernsQuestions ();
    this.entityName = 'ConcernsQuestions';
  }


  ngOnInit() {
    this.getTableInfo();
  }
}
