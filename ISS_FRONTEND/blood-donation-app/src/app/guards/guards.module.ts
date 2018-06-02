import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DoctorGuardService} from './doctor/doctor-guard.service';
import {DonorGuardService} from './donor/donor-guard.service';
import {PersonnelGuardService} from './personnel/personnel-guard.service';
import {AuthGuardService} from './auth/auth-guard.service';
import {AdminGuardService} from './admin/admin-guard.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [DoctorGuardService, DonorGuardService, PersonnelGuardService, AuthGuardService, AdminGuardService]
})
export class GuardsModule {
}
