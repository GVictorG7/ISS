import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AccountsComponent} from './accounts/accounts.component';
import {HospitalsComponent} from './hospitals/hospitals.component';


const routes: Routes = [
  {path: '', redirectTo: ''},
  {path: 'accounts', component: AccountsComponent},
  {path: 'hospitals', component: HospitalsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdministratorRoutingModule {
}
