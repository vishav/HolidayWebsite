import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CommonService} from "./common.service";

@Injectable({
  providedIn: 'root'
})
export class OldHinduLunarMoonphaseService extends CommonService {

  constructor(http: HttpClient) {
    super(http);
    this.baseUrl = 'http://localhost:8080/api/oldhindulunarmoonphase';
  }
}