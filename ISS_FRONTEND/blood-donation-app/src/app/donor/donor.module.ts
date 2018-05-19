import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {DonorRoutingModule} from "./donor-routing.module";
import {SharedModule} from "../shared/shared.module";
import { DonationsComponent } from './donations/donations.component';
import {
  MatButtonModule,
  MatFormFieldModule, MatInputModule,
  MatPaginatorModule, MatSnackBarModule,
  MatSortModule,
  MatTableModule
} from "@angular/material";
import {DonorService} from "./donor.service";
import { DonationFormComponent } from './donation-form/donation-form.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    DonorRoutingModule,
    SharedModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSnackBarModule
  ],
  declarations: [ DonationsComponent, DonationFormComponent],
  providers:[DonorService]
})
export class DonorModule { }
