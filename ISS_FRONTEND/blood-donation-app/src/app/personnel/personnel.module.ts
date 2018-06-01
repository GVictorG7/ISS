import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AnalysisComponent} from './analysis/analysis.component';
import {BloodRequestsComponent} from './blood-requests/blood-requests.component';
import {PersonnelRoutingModule} from './personnel-routing/personnel-routing.module';
import {SharedModule} from '../shared/shared.module';
import {EditDonationComponent} from './analysis/edit-donation/edit-donation.component';
import {MatButtonModule, MatPaginatorModule, MatSelectModule, MatSortModule, MatTableModule} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PersonnelService} from './personnel.service';
import {PersonnelDashboardComponent} from './personnel-dashboard/personnel-dashboard.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    PersonnelRoutingModule,
    MatTableModule,
    MatSelectModule,
    MatPaginatorModule,
    MatSortModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [AnalysisComponent, BloodRequestsComponent, EditDonationComponent, PersonnelDashboardComponent],
  providers: [PersonnelService]
})
export class PersonnelModule {
}
