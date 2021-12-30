import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BasicAuthenticationService } from './basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterBasicAuthService implements HttpInterceptor {

  constructor(private authenticationService: BasicAuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>  {
      let username = 'user';
      let password = 'password';
      let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
     
      request = request.clone({
        setHeaders : {
          Authorization : basicAuthHeaderString
        }
      })
      return next.handle(request);
    }
}
