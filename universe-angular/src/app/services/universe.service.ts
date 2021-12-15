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
      //'Content-Type': 'application/json',
    });
  }

  // allUser(): Observable<User[]> {
  //   return this.http.get<User[]>(this.url);
  // }

  byId(id: number): Observable<Universe> {
    return this.http.get<Universe>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  insert(universe: Universe): Observable<any> {
    const o = {
      name: universe.name,
    };
    return this.http.post<any>(this.url, o, {
      headers: this.httpHeaders,
    });
  }

  public all(): Observable<any> {
    return this.http.get<[]>(`${this.url}`, { headers: this.httpHeaders });
  }

  public addImage(id: number, image: File): Observable<any> {
    const formData = new FormData();

    formData.append('image', image);
    return this.http.post<[]>(`${this.url}/${id}/img`, formData, {
      headers: this.httpHeaders,
    });
  }

  //update();

  //delete();
}
