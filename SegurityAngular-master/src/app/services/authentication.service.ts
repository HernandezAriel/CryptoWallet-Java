import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url = "http://localhost:8080/login";
  currentUserSubject: BehaviorSubject<any>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('currentUser') || '{}'))
  }

  Login(credenciales: any): Observable<any> {
    return this.http.post(this.url, credenciales).pipe(map(data => {

      //sessionStorage me guarda la data hasta que se cierre el navegador
      //localStorage creo que me lo guarda para "siempre" en la pc
      sessionStorage.setItem('currentUser', JSON.stringify(data));
      this.currentUserSubject.next(data);
      return data;
    }
    ))
  }

  get AuthenticatedUser() {
    return this.currentUserSubject.value;
  }



}
