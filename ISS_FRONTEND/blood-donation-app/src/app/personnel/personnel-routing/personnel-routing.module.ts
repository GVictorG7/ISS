import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnalysisComponent} from '../analysis/analysis.component';
import {BloodRequestsComponent} from '../blood-requests/blood-requests.component';
import {PersonnelDashboardComponent} from '../personnel-dashboard/personnel-dashboard.component';


const routes: Routes = [
  {path: '', component: PersonnelDashboardComponent},
  {path: 'analysis', component: AnalysisComponent},
  {path: 'blood-requests', component: BloodRequestsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PersonnelRoutingModule {
}
