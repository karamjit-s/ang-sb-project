import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {
  currentUserValue: any;

  constructor(private http: HttpClient) { }

  authenticate(username, password) {
    if(username ==='user' && password ==='password') {
      sessionStorage.setItem('AuthenticatedUser', username);
      return true;
    }
    return false;
  }

  executeAuthenticationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    
    let headers = new HttpHeaders  ({
      Authorization: basicAuthHeaderString
    })

    return this.http.get(`http://localhost:8080/basicauth`,{headers});
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('AuthenticatedUser')
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('AuthenticatedUser');
  }
}
