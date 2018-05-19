import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {DonationsComponent} from "./donations/donations.component";
import {DonationFormComponent} from "./donation-form/donation-form.component";

const routes: Routes = [
  { path: 'donations', component:DonationsComponent  },
  { path: 'donation-form', component:DonationFormComponent  }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class DonorRoutingModule { }
