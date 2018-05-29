import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BloodRequestsComponent} from './blood-requests/blood-requests.component';
import {DoctorRoutingModule} from './doctor-routing/doctor-routing.module';
import {SharedModule} from '../shared/shared.module';
import {MatButtonModule, MatInputModule, MatPaginatorModule, MatSelectModule, MatSortModule, MatTableModule} from '@angular/material';
import {FormsModule} from '@angular/forms';
import {DoctorService} from './doctor.service';
import {HttpClientModule} from '@angular/common/http';
import { NewBloodRequestComponent } from './new-blood-request/new-blood-request.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    MatTableModule,
    MatInputModule,
    FormsModule,
    DoctorRoutingModule,
    MatSelectModule,
    MatPaginatorModule,
    MatButtonModule,
    MatSortModule,
    HttpClientModule
  ],
  declarations: [BloodRequestsComponent, NewBloodRequestComponent],
  providers: [DoctorService]
})
export class DoctorModule {
}
