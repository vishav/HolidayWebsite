import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import {HttpClient} from "@angular/common/http";
import {City} from "../spring-calender-server";
@Injectable({
  providedIn: 'root'
})
export class CitiesService {
  private baseUrl = 'http://localhost:8080/api/city';

  constructor(private http: HttpClient) { }

  /** GET citys from the server */
  getCities(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /** add a citys to the table **/
  createCity(city: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, city);
  }

  /** update a city name by id **/
  updateCity(id:number, city: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update` + `/${id}`, city);
  }

  deleteCity(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  deleteSelectedObjects(ids: any): Observable<any> {
    console.log("to be delete ", ids);
    return this.http.put(`${this.baseUrl}/delete-requests`, ids,{ responseType: 'text' });
  }

  getCitiesFields(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/fields`);
  }

  /** search a holiday to the table **/
  getSearchCities(city: City): Observable<any> {
    console.log("search that holiday locales ", city);
    return this.http.post(`${this.baseUrl}` + `/search`, city);
  }

}
