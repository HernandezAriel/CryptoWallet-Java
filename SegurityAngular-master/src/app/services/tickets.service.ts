import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class TicketsService {
  url: string = "http://localhost:8080/"
  id: number = 0;
  

  constructor(private http: HttpClient, private aS: AuthenticationService) { }

  async getTickets() :Promise<Observable<any>> {
    var currentUser = this.aS.AuthenticatedUser;

    this.getId(currentUser.username).subscribe(data => {
      this.id = data;
    })
    //para que me llegue a cargar el ID
    await new Promise(f => setTimeout(f, 50));
    return this.http.get<any>(this.url +"MyWallet/Tickets/"+this.id);    
  }
  getId(username: String): Observable<any> {
    return this.http.get<any>(this.url + "MyUsers/" + username);
  }
}
