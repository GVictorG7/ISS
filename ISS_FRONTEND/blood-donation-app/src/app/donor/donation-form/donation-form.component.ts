import {Component, OnInit} from '@angular/core';
import {DonationForm} from '../../core/model/DonationForm';
import {DonorService} from '../donor.service';
import {MatSnackBar} from '@angular/material';
import {Donor} from '../../core/model/Donor';
import {checkCompleted} from '../../shared/utils/utils';

@Component({
  selector: 'app-donation-form',
  templateUrl: './donation-form.component.html',
  styleUrls: ['./donation-form.component.css']
})
export class DonationFormComponent implements OnInit {
  donor: Donor = null;
  donationForm: DonationForm = new DonationForm();
  tooltip: any = {disabled: false, message: ''};

  constructor(private service: DonorService, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.donor = JSON.parse(localStorage.getItem('token')).userData;
    this.setDonationFormProperties();


  }

  private setDonationFormProperties() {
    this.donationForm.firstName = this.donor.firstName;
    this.donationForm.lastName = this.donor.lastName;
    this.donationForm.birthday = this.donor.birthday;
    this.donationForm.address.address = this.donor.address;
    this.donationForm.localAddress.address = this.donor.localAddress;
    this.donationForm.email = this.donor.email;
    this.donationForm.phone = this.donor.phone;
  }

  saveDonation() {
    if (checkCompleted(this.donationForm)) {
      this.service.saveDonation(this.donationForm);
    } else {
      this.snackBar.open('Date completate gresit!', 'Ok', {duration: 1000});
    }
  }
}


