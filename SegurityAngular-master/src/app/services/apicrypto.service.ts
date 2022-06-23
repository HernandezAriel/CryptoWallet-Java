import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApicryptoService {

  private url: String = "https://criptoya.com/api/satoshitango/";

  constructor(public http : HttpClient) { }

    getToken(name: string){
      return this.http.get(`${this.url}${name}/ars`)
    }
  
}
