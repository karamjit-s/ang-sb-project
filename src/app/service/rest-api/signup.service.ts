import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {


  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/signup/signup';

  constructor(private http: HttpClient) { }

  getSignup(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createSignUp(signUp: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, signUp);
  }

  updatesignup(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletesignup(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getSignupList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
