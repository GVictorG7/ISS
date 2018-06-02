import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnalysisComponent} from '../analysis/analysis.component';
import {BloodRequestsComponent} from '../blood-requests/blood-requests.component';
import {PersonnelDashboardComponent} from '../personnel-dashboard/personnel-dashboard.component';
import {BloodBankComponent} from '../blood-bank/blood-bank.component';


const routes: Routes = [
  {path: '', redirectTo: 'dashboard'},
  {path: 'dashboard', component: PersonnelDashboardComponent},
  {path: 'analysis', component: AnalysisComponent},
  {path: 'blood-requests', component: BloodRequestsComponent},
  {path: 'blood-bank', component: BloodBankComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PersonnelRoutingModule {
}
