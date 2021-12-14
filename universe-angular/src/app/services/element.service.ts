import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ElementService {
  
  private url = 'http://localhost:8080/universe/api/100/element';
  
  constructor( private http :HttpClient ) {}
  
  public byId( id :number ) :Observable<any> {
    return this.http.get<[]>(`${ this.url }/${ id }`, { headers: this.httpHeaders } );
  }

  public addImage( id :number, image :File ) :Observable<any> {
    const formData = new FormData();

    formData.append('image', image);
    console.log( `${ this.url }/${ id }/img` );
    return this.http.post<[]>( `${ this.url }/${ id }/img`, formData, { headers: this.httpHeaders } );
  }
  
  public insert( o :any ) :Observable<any> {
    return this.http.post<[]>( this.url, o, { headers: this.httpHeaders } );
  }

  private get httpHeaders(): HttpHeaders {
    //console.log( sessionStorage.getItem('token') )
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      // 'Content-Type': 'application/json',
    });
  }

  public dummyElement() :Observable<any> {
    return this.http.get<[]>( this.url );
  }

  
}
