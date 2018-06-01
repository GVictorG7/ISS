import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Donation} from '../../../core/model/Donation';
import {PersonnelService} from '../../personnel.service';

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

  constructor(private service: PersonnelService) {
  }

  ngOnInit() {
    this.service.getHealthIssues().subscribe(iss => this.healthIssues = iss);
  }

  saveInfo() {
    this.service.updateDonation(this.donation).subscribe();
  }

  ngOnDestroy(): void {
    console.log('on destroy');
  }

}
