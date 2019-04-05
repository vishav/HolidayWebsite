import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HolidaysLocalesDetails} from "../spring-calender-server";
@Injectable({
  providedIn: 'root'
})
export class HolidaysLocalesDetailsService {
  private baseUrl = 'http://localhost:8080/api/holidaysLocalesDetails';
  constructor(private http: HttpClient) { }

  /** GET holidaysLcoales from the server */
  getHolidaysLocalesDetails(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /** search a holiday to the table **/
  getSearchHolidaysLocalesDetails(holiday: HolidaysLocalesDetails): Observable<any> {
    console.log("search that holiday locales ", holiday);
    return this.http.post(`${this.baseUrl}` + `/search`, holiday);
  }

  getHolidaysLocalesDetailsFields(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/fields`);
  }

  /** add a holidays to the table **/
  createHolidaysLocalesDetails(holiday: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, holiday);
  }

  /** update a holiday to the table **/
  updateHolidaysLocalesDetails(id:number, holiday: Object): Observable<Object> {
    console.log("service: update by id "+holiday);
    return this.http.put(`${this.baseUrl}` + `/update/` + `/${id}`, holiday);
  }

  /** update a holiday locale record to the table by id **/
  deleteHolidaysLocalesDetails(id: number): Observable<any> {
    console.log("service: delete by id "+id);
    return this.http.delete(`${this.baseUrl}`+`/${id}`, { responseType: 'text' });
  }

  deleteSelectedObjects(ids: any): Observable<any> {
    console.log("to be delete ", ids);
    return this.http.put(`${this.baseUrl}/delete-requests`, ids,{ responseType: 'text' });
  }


}
