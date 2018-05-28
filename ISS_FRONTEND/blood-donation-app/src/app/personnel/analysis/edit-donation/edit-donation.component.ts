import {Component, Input, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-edit-donation',
  templateUrl: './edit-donation.component.html',
  styleUrls: ['./edit-donation.component.css']
})
export class EditDonationComponent implements OnInit, OnDestroy {
  @Input() donation: any = {status: 'DESCHIS', healthIssues: [], date: '', blood: {id: 0, category: '', RH: '', type: ''}};
  statuses: any[] = ['DESCHIS', 'ACCEPTAT', 'RESPINS'];
  healthIssues: any[] = ['holera', 'gonoree', 'cancer', 'sida', 'gravid'];
  types = ['0', 'A', 'B', 'AB'];
  rhs = ['Pozitiv', 'Negativ'];
  categories = ['Integral', 'Plasma', 'Trombocite', 'Globule rosii'];

  constructor() {
  }

  ngOnInit() {
  }

  saveInfo() {
    if (this.donation.status === 'ACCEPTAT') {
      this.donation.healthIssues = [];
    }
  }

  ngOnDestroy(): void {
    console.log('on destroy');
  }

}
