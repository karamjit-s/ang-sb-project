import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpErrorResponse,
} from "@angular/common/http";
import { Router } from "@angular/router";
import { Observable, throwError } from "rxjs";

import { catchError } from "rxjs/operators";
import { AppConfig } from "../../app-config";
import { UserInfoService } from "../http/user-info.service";

@Injectable()
export class ApiRequestService {
  constructor(
    private appConfig: AppConfig,
    private http: HttpClient,
    private router: Router,
    private userInfoService: UserInfoService
  ) {}

  /**
   * This is a Global place to add all the request headers for every REST calls
   */
  /*{let headers = new HttpHeaders({
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'POST, GET, DELETE, OPTIONS, PUT',
        'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, Accept-Encoding, Accept-Language, Host, Referer, Connection, User-Agent, authorization, sw-useragent, sw-version'
    });*/
  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    //let token = this.userInfoService.getStoredToken();
    //console.log('Token from session storage: ', token);
    headers = headers.append("Content-Type", "application/json");
    /* if (token !== null) {
      headers = headers.append("Authorization", token);
    } */
    return headers;
  }

  getMultipartHeader(): HttpHeaders {
    let headers = new HttpHeaders();
    headers = headers.append("Content-Type", "multipart/form-data");
    return headers;

  }

  errMsg: string = '';

  handleError(error: HttpErrorResponse) {
    let me = this;
    console.log("handleError ", error.message);
    switch(error.status) {
      case 401:
        this.errMsg = 'Forbidden';
        break;
      case 404:
        this.errMsg = 'Service not found';
      case 408:
        this.errMsg = 'Request Timedout';
      case 500:
        this.errMsg = 'Internal Server Error';
      default:
        this.errMsg = 'Server Error';
    }
    return throwError(error.message);
    //return Observable.throw(error.message);
  }

  get(url: string, urlParams?: HttpParams): Observable<any> {
    let me = this;
    return this.http
      .get(this.appConfig.baseApiPath + url, {
        headers: this.getHeaders(),
        params: urlParams,
      }).pipe(
        catchError((error) => {
          return throwError(error || "Server error");
        })
      )
  }

  loginAuthentication(url: string, body: Object): Observable<any> {
    let me = this;
    return this.http
      .post(this.appConfig.baseApiPath + url, JSON.stringify(body), {
        headers: this.getHeaders()
      }).pipe(
        catchError((error) => {
          return throwError(error || "Server error");
        })
      )
  }

  // modified params
  post(url: string, body: any, urlParams?: HttpParams): Observable<any> {
    let me = this;
    let bodyTest = body instanceof Object ? JSON.stringify(body) : body;
    console.log('Post method String Vs. Object', bodyTest);
    return this.http
      .post(this.appConfig.baseApiPath + url, JSON.stringify(body), {
        headers: this.getHeaders(),
        params: urlParams,
      }).pipe(
        catchError((error) => {
          return throwError(error || "Server error");
        })
      )
  }

  // [Multipart file Support]
  postFormData(url: string, body: any, urlParams?: HttpParams): Observable<any> {
    //let me = this;
    //headers: this.getMultipartHeader(),
    return this.http
      .post(this.appConfig.baseApiPath + url, body, {
        params: urlParams,
        reportProgress: true, 
        observe: 'events'
      }).pipe(
        catchError((error) => {
          return throwError(error || "Server error");
        })
      )
  }

  // modified params
  put(url: string, body: Object, urlParams?: HttpParams): Observable<any> {
    let me = this;
    return this.http
      .put(this.appConfig.baseApiPath + url, JSON.stringify(body), {
        headers: this.getHeaders(),
        params: urlParams,
      }).pipe(
        catchError((error) => {
          return throwError(error || "Server error");
        })
      )
  }

  delete(url: string): Observable<any> {
    let me = this;
    return this.http
      .delete(this.appConfig.baseApiPath + url, { headers: this.getHeaders() })
      .pipe(
        catchError((error) => {
          return throwError(error || "Server error");
        })
      )
  }
}
