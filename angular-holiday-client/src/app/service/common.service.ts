import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  /** this url will be replace by sub service **/
  public baseUrl;
  constructor(private http: HttpClient) {

  }

  /** GET table list from the server */
  getAll(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  /** search  to the table **/
  getSearch(object: Object): Observable<any> {
    console.log("search that object", object);
    return this.http.post(`${this.baseUrl}` + `/search`, object);
  }

  /** add a countrys to the table **/
  create(object: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, object);
  }
  /** update a country name by id **/
  update(id:number, object: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}` + `/update` + `/${id}`, object);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  deleteSelectedObjects(ids: any): Observable<any> {
    console.log("to be delete ", ids);
    return this.http.put(`${this.baseUrl}/delete-requests`, ids,{ responseType: 'text' });
  }


  getFields(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+ `/fields`);
  }

}
