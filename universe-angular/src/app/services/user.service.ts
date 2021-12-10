import { User } from './../model/user';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  url: string = 'http://localhost:8080/universe/api/user';

  constructor(private http: HttpClient) {}

  get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  allUser(): Observable<User[]> {
    return this.http.get<User[]>(this.url);
  }

  byId(id: number): Observable<User> {
    return this.http.get<User>(this.url + '/' + id);
  }

  insert(user: User): Observable<User> {
    const o = {
      login: user.login,
      password: user.password,
    };
    return this.http.post<User>(this.url, o);
  }

  update(user: User): Observable<User> {
    return this.http.put<User>(this.url + '/' + user.id, user, {
      headers: this.httpHeaders,
    });
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  checkLogin(login: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/login/' + login);
  }
}
