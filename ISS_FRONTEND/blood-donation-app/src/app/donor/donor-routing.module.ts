import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DonationsComponent} from './donations/donations.component';
import {DonationFormComponent} from './donation-form/donation-form.component';

const routes: Routes = [
  {path: '', redirectTo: 'donations'},
  {path: 'donations', component: DonationsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DonorRoutingModule {
}
