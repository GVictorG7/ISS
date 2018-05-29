import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AnalysisComponent} from './analysis/analysis.component';
import {BloodRequestsComponent} from './blood-requests/blood-requests.component';
import {PersonnelRoutingModule} from './personnel-routing/personnel-routing.module';
import {SharedModule} from '../shared/shared.module';
import {EditDonationComponent} from './analysis/edit-donation/edit-donation.component';
import {MatButtonModule, MatPaginatorModule, MatSelectModule, MatSortModule, MatTableModule} from '@angular/material';
import {FormsModule} from '@angular/forms';
import {PersonnelService} from './personnel.service';

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
    FormsModule
  ],
  declarations: [AnalysisComponent, BloodRequestsComponent, EditDonationComponent],
  providers: [PersonnelService]
})
export class PersonnelModule {
}
