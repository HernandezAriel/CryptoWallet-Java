import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private ruta:Router) { }

  ngOnInit(): void {
  }

  logout(){
    sessionStorage.clear();
    this.ruta.navigate(['/login']);
  }
  home(){
    this.ruta.navigate(['/my-wallet']);
  }
  history(){
    this.ruta.navigate(['/history']);
  }


}
