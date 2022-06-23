import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenReducido } from '../model/TokenReducido';

@Injectable({
  providedIn: 'root'
})
export class AddTokensService {
  URL = 'http://localhost:8080/MyWallet/';
  constructor(private http: HttpClient) { }

  addToken(tokenReducido :TokenReducido){
    return this.http.post<TokenReducido>(this.URL+"AddToken/",tokenReducido);
  }
}
