import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RelationService {
  private url = 'http://localhost:8080/universe/api'; //100/element

  constructor(private http :HttpClient) {}

  public byName( nature :string) {
    return this.http.get<[]>(`${this.url}/${this.universe_id}/relation/likeName/${nature}`, {
      headers: this.httpHeaders,
    });
  }

  public save( relation: any ) {
    return this.http.post<[]>(`${this.url}/${this.universe_id}/relation/`, relation , {
      headers: this.httpHeaders,
    });
  }

  get universe_id() {
    return Number(sessionStorage.getItem('universe_id'));
  }

  private get httpHeaders(): HttpHeaders {
    //console.log( sessionStorage.getItem('token') )
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      // 'Content-Type': 'application/json',
    });
  }
  
}
