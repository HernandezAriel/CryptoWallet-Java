import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor{

  constructor(private aS:AuthenticationService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  var currentUser=this.aS.AuthenticatedUser;
  if(currentUser && currentUser.token){
  req= req.clone({
    setHeaders:{
      Authorization: `Bearer ${currentUser.token}`
    }
  })
  }
    return next.handle(req);
  }

  
}
