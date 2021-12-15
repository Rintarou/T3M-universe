import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ElementService {
  private url = 'http://localhost:8080/universe/api'; //100/element

  constructor(private http: HttpClient) {}

  public byId(id: number, universe_id: number): Observable<any> {
    return this.http.get<[]>(`${this.url}/${universe_id}/element/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public all(universe_id: number): Observable<any> {
    return this.http.get<[]>(`${this.url}/${universe_id}/element`, {
      headers: this.httpHeaders,
    });
  }

  public addImage(
    id: number,
    image: File,
    universe_id: number
  ): Observable<any> {
    const formData = new FormData();

    formData.append('image', image);
    console.log(`${this.url}/${id}/img`);
    return this.http.post<[]>(
      `${this.url}/${universe_id}/element/${id}/img`,
      formData,
      { headers: this.httpHeaders }
    );
  }

  public insert(o: any, universe_id: number): Observable<any> {
    return this.http.post<[]>(this.url + '/' + universe_id + '/element', o, {
      headers: this.httpHeaders,
    });
  }

  private get httpHeaders(): HttpHeaders {
    //console.log( sessionStorage.getItem('token') )
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      // 'Content-Type': 'application/json',
    });
  }

  public dummyElement(universe_id: number): Observable<any> {
    return this.http.get<[]>(this.url + '/' + universe_id + '/element');
  }
}
