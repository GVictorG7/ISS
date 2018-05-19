import {Component, OnInit} from '@angular/core';
import {DonationForm} from "../../core/model/DonationForm";
import {Person} from "../../core/model/Person";
import {DonorService} from "../donor.service";
import {MatSnackBar} from "@angular/material";

@Component({
  selector: 'app-donation-form',
  templateUrl: './donation-form.component.html',
  styleUrls: ['./donation-form.component.css']
})
export class DonationFormComponent implements OnInit {
  donor: Person = null;
  donationForm: DonationForm = new DonationForm();

  constructor(private service:DonorService, private snackBar:MatSnackBar) {
  }

  ngOnInit() {
    this.donor = JSON.parse(localStorage.getItem('token'));
    this.setDonationFormProperties();


  }

  private setDonationFormProperties() {
    this.donationForm.firstName = this.donor.firstName;
    this.donationForm.lastName = this.donor.lastName;
    this.donationForm.birthday = this.birthdayToString();
  }

  private birthdayToString() {
    let birthday = this.donor.cnp.substr(1, 6);
    return `${birthday.substr(-2)}/${birthday.substr(2,2)}/19${birthday.substr(0,2)}`;
  }

  saveDonation(){
    if(this.checkFields())
      this.service.saveDonation(this.donationForm);
    else
      this.snackBar.open("Date completate gresit!", 'Ok', {duration: 1000});
  }

  private checkFields() {
    for (let property in this.donationForm )
      if(this.donationForm[property] === '')
        return false;
    return true;
  }
}


