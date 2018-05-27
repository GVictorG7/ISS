import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BloodRequestsComponent} from './blood-requests/blood-requests.component';
import {DoctorRoutingModule} from './doctor-routing/doctor-routing.module';
import {SharedModule} from '../shared/shared.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    DoctorRoutingModule
  ],
  declarations: [BloodRequestsComponent]
})
export class DoctorModule {
}
