import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AdministratorService} from './administrator.service';
import {HospitalsComponent} from './hospitals/hospitals.component';
import {AccountsComponent} from './accounts/accounts.component';
import {AdministratorRoutingModule} from './administrator-routing.module';
import {SharedModule} from '../shared/shared.module';
import {MatButtonModule, MatSnackBarModule} from '@angular/material';
import {AuthService} from '../auth/auth.service';
import {HttpClientModule} from '@angular/common/http';
import {AuthModule} from '../auth/auth.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    AdministratorRoutingModule
  ],
  declarations: [HospitalsComponent, AccountsComponent],
  providers: [AdministratorService]
})
export class AdministratorModule {
}
