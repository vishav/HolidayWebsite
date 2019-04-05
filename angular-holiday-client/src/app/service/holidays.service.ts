import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import {HttpClient} from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class HolidaysService {
  private baseUrl = 'http://localhost:8080/api/holidays';

  constructor(private http: HttpClient) { }

  /** GET holidays from the server */
  getHolidays(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /** search  to the table **/
  getSearch(object: Object): Observable<any> {
    console.log("search that object", object);
    return this.http.post(`${this.baseUrl}` + `/search`, object);
  }

  /** add a holidays to the table **/
  createHoliday(holiday: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, holiday);
  }

  /** update a holiday name by id **/
  updateHoliday(id:number, holiday: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update` + `/${id}`, holiday);
  }

  deleteHoliday(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  deleteSelectedHoliday(ids: any): Observable<any> {
    console.log("to be delete ", ids);
    return this.http.put(`${this.baseUrl}/delete-requests`, ids,{ responseType: 'text' });
  }

  getHolidaysFields(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/fields`);
  }

  getHolidaysByOneField(field: string, value: any){

    return this.http.get(`${this.baseUrl}/${field}/${value}`);
  }

}
