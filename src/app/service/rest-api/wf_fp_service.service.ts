import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class wf_fp_service {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8900/springboot-crud-rest/api/wfb/wfb' ;

  build_wf(ohwf_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${ohwf_id}`);
  } 

  addOhForm(ohwf: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, ohwf);
  }

  updateOhwf(ohwf_id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${ohwf_id}`, value);
  }

  deleteOhwf(ohwf_id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${ohwf_id}`, { responseType: 'text' });
  }

  getOhFormList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  
}
