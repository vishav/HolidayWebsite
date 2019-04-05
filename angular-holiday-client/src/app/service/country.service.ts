import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {HttpClient} from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private baseUrl = 'http://localhost:8080/api/country';

  constructor(private http: HttpClient) { }

  /** GET countrys from the server */
  getCountries(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /** search a holiday to the table **/
  getSearch(object: Object): Observable<any> {
    console.log("search that holiday locales ", object);
    return this.http.post(`${this.baseUrl}` + `/search`, object);
  }

  /** add a countrys to the table **/
  createCountry(country: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, country);
  }

  /** update a country name by id **/
  updateCountry(id:number, country: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update` + `/${id}`, country);
  }

  deleteCountry(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
  deleteSelectedCountry(ids: any): Observable<any> {
    console.log("to be delete ", ids);
    return this.http.put(`${this.baseUrl}/delete-requests`, ids,{ responseType: 'text' });
  }

  getCountrysFields(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/fields`);
  }

  getCountrysByOneField(field: string, value: any){

    return this.http.get(`${this.baseUrl}/${field}/${value}`);
  }

}
