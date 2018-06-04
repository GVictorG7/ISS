import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DonationForm} from '../../core/model/DonationForm';
import {DonorService} from '../donor.service';
import {MatSnackBar} from '@angular/material';
import {Donor} from '../../core/model/Donor';
import {checkCompleted} from '../../shared/utils/utils';
import {Router} from '@angular/router';
import {b} from '@angular/core/src/render3';

@Component({
  selector: 'app-donation-form',
  templateUrl: './donation-form.component.html',
  styleUrls: ['./donation-form.component.css']
})
export class DonationFormComponent implements OnInit {
  donor: Donor = null;
  donationForm: DonationForm = new DonationForm();
  @Output() closeModal = new EventEmitter<boolean>();

  constructor(private service: DonorService, private snackBar: MatSnackBar, private router: Router) {
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
      this.service.saveDonation(this.donationForm).subscribe(
        () => {
          this.snackBar.open('Saved!', 'Ok', {duration: 3000});
          this.router.navigateByUrl('');
        });
    } else {
      this.snackBar.open('Fields completed incorrectly!', 'Ok', {duration: 3000});
    }
  }

  close() {
    this.closeModal.emit(false);
  }
}


