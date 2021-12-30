import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestCdkServiceService {

  
  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8900/springboot-crud-rest/testcdk/testcdk' ;

  // getCompany(id: number): Observable<any> {
  //   return this.http.get(`${this.baseUrl}/${id}`);
  // }

  addElement(test_Cdk_object: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, test_Cdk_object);
  }

  // updateCompany(id: number, value: any): Observable<Object> {
  //   return this.http.put(`${this.baseUrl}/${id}`, value);
  // }

  // deleteCompany(id: number): Observable<any> {
  //   return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  // }

  getCompanyList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }


}
