import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Donation} from '../../../core/model/Donation';
import {PersonnelService} from '../../personnel.service';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-edit-donation',
  templateUrl: './edit-donation.component.html',
  styleUrls: ['./edit-donation.component.css']
})
export class EditDonationComponent implements OnInit {
  @Input() donation: Donation;
  @Output() closeCompleteDonation = new EventEmitter<boolean>();
  @Output() donationEdited = new EventEmitter<boolean>();
  statuses: any[] = ['OPEN', 'ACCEPTED', 'REJECTED'];
  healthIssues: string[];
  types = ['O', 'A', 'B', 'AB'];
  rhs = ['POSITIVE', 'NEGATIVE'];
  formGroup: FormGroup;

  constructor(private service: PersonnelService, private formBuilder: FormBuilder, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.service.getHealthIssues().subscribe(iss => this.healthIssues = iss);
    this.formGroup = this.formBuilder.group({
      healthIssue: ['', this.checkIssues()],
      bloodType: ['', Validators.required],
      bloodRH: ['', Validators.required]
    });
  }

  saveInfo() {
    this.service.updateDonation(this.donation).subscribe(
      () => {
        this.donationEdited.emit(true);
        this.close();
        this.snackBar.open('Donation filled succesfully!', 'Ok', {duration: 3000});
      },
      () => {
        this.donationEdited.emit(false);
        this.snackBar.open('We couldn\'t fill donation. Try again or cancel!', 'Dismiss', {duration: 3000});
      });
  }

  private checkIssues() {
    return (control: AbstractControl): { [key: string]: any } => {
      let lengthSelectedHI = 0;
      if (this.donation.status === 'REJECTED') {
        lengthSelectedHI = control.value.length;
        return lengthSelectedHI > 0 ? null : {'healthIssue': {value: {}}};
      }
      return null;
    };
  }

  close() {
    this.closeCompleteDonation.emit(false);
  }
}
