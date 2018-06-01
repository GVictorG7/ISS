import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Donation} from '../../../core/model/Donation';
import {PersonnelService} from '../../personnel.service';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-edit-donation',
  templateUrl: './edit-donation.component.html',
  styleUrls: ['./edit-donation.component.css']
})
export class EditDonationComponent implements OnInit, OnDestroy {
  @Input() donation: Donation;
  statuses: any[] = ['OPEN', 'ACCEPTED', 'REJECTED'];
  healthIssues: string[];
  types = ['O', 'A', 'B', 'AB'];
  rhs = ['POSITIVE', 'NEGATIVE'];
  formGroup: FormGroup;

  constructor(private service: PersonnelService, private formBuilder: FormBuilder) {
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
    this.service.updateDonation(this.donation).subscribe();
  }

  ngOnDestroy(): void {
    console.log('on destroy');
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
}
