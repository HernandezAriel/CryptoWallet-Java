import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class SingInService {
  URL = 'http://localhost:8080/MyUsers/save';
  constructor(public http : HttpClient) { }


  addUser(user :User){
    return this.http.post<User>(this.URL,user);
  }
}
