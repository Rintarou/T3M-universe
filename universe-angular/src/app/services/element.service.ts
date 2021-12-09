import { HttpClient } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ElementService {

  private url = 'http://localhost:8080/universe/api/element';

  constructor( private http :HttpClient ) {}

  public byId( id :number ) :Observable<any> {
    return this.http.get<[]>(`${ this.url }/${ id }`);
  }

  public insert( o :any ) {
    // console.log( JSON.stringify( o ) );
    this.http.post<[]>( this.url, o ).subscribe( console.info );
  }

  public dummyElement() :Observable<any> {
    return this.http.get<[]>( this.url );
  }

  
}
