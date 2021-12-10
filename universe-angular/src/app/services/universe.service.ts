import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Universe } from './../model/universe';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UniverseService {
  url: string = 'http://localhost:8080/universe/api/universe';

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  // allUser(): Observable<User[]> {
  //   return this.http.get<User[]>(this.url);
  // }

  byId(id: number): Observable<Universe> {
    return this.http.get<Universe>(this.url + '/' + id);
  }

  //update();

  //delete();
}
