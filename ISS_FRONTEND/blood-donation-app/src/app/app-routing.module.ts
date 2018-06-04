import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AuthGuardService} from './guards/auth/auth-guard.service';
import {AdminGuardService} from './guards/admin/admin-guard.service';
import {DoctorGuardService} from './guards/doctor/doctor-guard.service';
import {DonorGuardService} from './guards/donor/donor-guard.service';
import {PersonnelGuardService} from './guards/personnel/personnel-guard.service';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'administrator', loadChildren: './administrator/administrator.module#AdministratorModule', canLoad: [AdminGuardService]},
  {path: 'auth', loadChildren: './auth/auth.module#AuthModule', canLoad: [AuthGuardService]},
  {path: 'doctor', loadChildren: './doctor/doctor.module#DoctorModule', canLoad: [DoctorGuardService]},
  {path: 'donor', loadChildren: './donor/donor.module#DonorModule', canLoad: [DonorGuardService]},
  {path: 'personnel', loadChildren: './personnel/personnel.module#PersonnelModule', canLoad: [PersonnelGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
