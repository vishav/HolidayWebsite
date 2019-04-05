import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from "@angular/common/http";
import {State} from "../spring-calender-server";

@Injectable({
  providedIn: 'root'
})
export class StatesService {
  private baseUrl = 'http://localhost:8080/api/states';

  constructor(private http: HttpClient) { }

  /** GET states from the server */
  getStates(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /** search a holiday to the table **/
  getSearchStates(state: State): Observable<any> {
    return this.http.post(`${this.baseUrl}` + `/search`, state);
  }

  /** add a states to the table **/
  createState(state: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, state);
  }

  /** update a state name by id **/
  updateState(id:number, state: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update` + `/${id}`, state);
  }

  deleteState(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  deleteSelectedStates(ids: any): Observable<any> {
    console.log("to be delete ", ids);
    return this.http.put(`${this.baseUrl}/delete-requests`, ids,{ responseType: 'text' });
  }

  getStatesFields(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/fields`);
  }

  getStatesByOneField(field: string, value: any){

    return this.http.get(`${this.baseUrl}/${field}/${value}`);
  }

}
