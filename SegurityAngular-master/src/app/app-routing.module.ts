import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MyWalletComponent } from './components/my-wallet/my-wallet.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { GuardGuard } from './services/guard.guard';

const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'my-wallet',component:MyWalletComponent,canActivate:[GuardGuard]},
  {path:'history',component:TicketsComponent,canActivate:[GuardGuard]},
  {path:'',redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
