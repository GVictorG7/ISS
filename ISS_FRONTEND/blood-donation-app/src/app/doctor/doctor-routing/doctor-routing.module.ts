import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {BloodRequestsComponent} from '../blood-requests/blood-requests.component';


const routes: Routes = [
  {path: '', redirectTo: 'blood-requests'},
  {path: 'blood-requests', component: BloodRequestsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class DoctorRoutingModule {
}
