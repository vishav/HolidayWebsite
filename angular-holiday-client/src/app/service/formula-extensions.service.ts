import { Injectable } from '@angular/core';
import {CommonService} from "./common.service";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class FormulaExtensionsService extends CommonService{

  constructor(http: HttpClient) {
    super(http);
    this.baseUrl = 'http://localhost:8080/api/formulaextensions';
  }
}
