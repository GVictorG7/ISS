import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'administrator', loadChildren: './administrator/administrator.module#AdministratorModule'},
  {path: 'auth', loadChildren: './auth/auth.module#AuthModule'},
  {path: 'doctor', loadChildren: './doctor/doctor.module#DoctorModule'},
  {path: 'donor', loadChildren: './donor/donor.module#DonorModule'},
  {path: 'home', component: HomeComponent},
  {path: 'personnel', loadChildren: './personnel/personnel.module#PersonnelModule'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
