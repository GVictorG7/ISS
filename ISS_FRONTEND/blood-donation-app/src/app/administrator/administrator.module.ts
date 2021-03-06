import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AdministratorService} from './administrator.service';
import {HospitalsComponent} from './hospitals/hospitals.component';
import {AccountsComponent} from './accounts/accounts.component';
import {AdministratorRoutingModule} from './administrator-routing.module';
import {SharedModule} from '../shared/shared.module';
import {
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule,
  MatPaginatorModule, MatSelectModule,
  MatSnackBarModule, MatSortModule,
  MatTableModule
} from '@angular/material';
import {AuthService} from '../auth/auth.service';
import {HttpClientModule} from '@angular/common/http';
import {AuthModule} from '../auth/auth.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    MatButtonModule,
    MatSnackBarModule,
    FormsModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatTableModule,
    MatInputModule,
    MatSelectModule,
    HttpClientModule,
    AdministratorRoutingModule,
    MatSortModule,
    ReactiveFormsModule
  ],
  declarations: [HospitalsComponent, AccountsComponent],
  providers: [AdministratorService]
})
export class AdministratorModule {
}
