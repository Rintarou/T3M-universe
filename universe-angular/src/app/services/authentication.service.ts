import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService implements CanActivate {
  url: string = 'http://localhost:8080/universe/api/auth';

  constructor(private http: HttpClient, private router: Router) {}

  public canActivate(): boolean {
    if (!!sessionStorage.getItem('token')) {
      return true;
    } else {
      this.router.navigate(['/login'], { queryParams: { error: 'auth' } });
    }
    return false;
  }

  public auth(login: string, password: string): Observable<any> {
    const httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
      'Content-Type': 'application/json',
    });
    return this.http.get(this.url, {
      headers: httpHeaders,
    });
  }
}
