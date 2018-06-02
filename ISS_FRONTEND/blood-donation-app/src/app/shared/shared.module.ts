import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MenuComponent} from './menu/menu.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {
  MatButtonModule, MatCardModule,
  MatFormFieldModule, MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatSelectModule,
  MatSidenavModule,
  MatSnackBarModule,
  MatStepperModule
} from '@angular/material';
import {RegisterComponent} from './register/register.component';
import {UserDataComponent} from './register/user-data/user-data.component';
import {DonorDataComponent} from './register/donor-data/donor-data.component';
import {PersonnelDataComponent} from './register/personnel-data/personnel-data.component';
import {DoctorDataComponent} from './register/doctor-data/doctor-data.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {DonationDetailsComponent} from './donation-details/donation-details.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatSnackBarModule,
    MatStepperModule,
    ReactiveFormsModule


  ],
  declarations: [
    MenuComponent,
    RegisterComponent,
    UserDataComponent,
    DonorDataComponent,
    PersonnelDataComponent,
    DoctorDataComponent,
    DonationDetailsComponent,
  ],
  exports: [
    MenuComponent,
    DonorDataComponent,
    RegisterComponent,
    PersonnelDataComponent,
    DoctorDataComponent,
    UserDataComponent,
    DonationDetailsComponent,
  ]
})
export class SharedModule {
}
