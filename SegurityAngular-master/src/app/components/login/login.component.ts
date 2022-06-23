import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { SingInService } from 'src/app/services/sing-in.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form:FormGroup;
  user:User = new User("","");
  constructor(private formBuilder:FormBuilder, private sS:SingInService, private authenticationService:AuthenticationService, private ruta:Router){
    this.form=this.formBuilder.group(
      {
        username:["",[Validators.required]],
        password:["",[Validators.required, Validators.minLength(3)]]
      }
    ) 
    this.form=this.formBuilder.group(
      {
        username:["",[Validators.required]],
        password:["",[Validators.required, Validators.minLength(3)]]
      }
    ) 

  }
  ngOnInit(): void {
  }
  //para acceder a los form
  get Username()
  {
    return this.form.get('username');
  }
  get Password(){
    return this.form.get('password');
  }

  onSend(event:Event)
  {
    //cuando clickeo salgo de lo esperado en el form
    event.preventDefault;
    console.log(this.form.value);
    this.authenticationService.Login(this.form.value).subscribe(data =>{
      console.log("DATA:" + JSON.stringify(data));
      this.ruta.navigate(['/my-wallet']);
    })
  }
  addUser(user:User){
    this.sS.addUser(user).subscribe(data => {console.log("se agrego bien")});
  }
}
