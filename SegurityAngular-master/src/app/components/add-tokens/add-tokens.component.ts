import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddTokensService } from 'src/app/services/add-tokens.service';

@Component({
  selector: 'app-add-tokens',
  templateUrl: './add-tokens.component.html',
  styleUrls: ['./add-tokens.component.css']
})
export class AddTokensComponent implements OnInit {

  constructor(private aDS:AddTokensService,private ruta:Router) { }
  tokenName:string="ETH";
  ngOnInit(): void {
  }
  addToken(tokenName: string){
//id wallet lo saco como antes
    /*this.aDS.addToken(tokenName,id_Wallet).subscribe(data => {
      console.log("DATA:" + JSON.stringify(data));
      this.ruta.navigate(['/my-wallet'])}) */
  }

  setToken(token: string){
    this.tokenName=token;
  }
  
}
