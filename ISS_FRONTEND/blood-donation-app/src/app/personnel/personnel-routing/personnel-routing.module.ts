import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnalysisComponent} from '../analysis/analysis.component';
import {BloodRequestsComponent} from '../blood-requests/blood-requests.component';


const routes: Routes = [
  {path: 'analysis', component: AnalysisComponent},
  {path: 'blood-requests', component: BloodRequestsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PersonnelRoutingModule {
}
