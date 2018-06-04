import {Component, OnInit} from '@angular/core';
import {PersonnelService} from '../personnel.service';

@Component({
  selector: 'app-personnel-dashboard',
  templateUrl: './personnel-dashboard.component.html',
  styleUrls: ['./personnel-dashboard.component.css']
})
export class PersonnelDashboardComponent implements OnInit {
  cards = [
    {
      title: 'New donations',
      cols: 1,
      rows: 1,
      imageUrl: 'assets/personnel/dashboard/new-donation.png',
      counter: 2,
      redirect: 'personnel/analysis'
    },
    {
      title: 'New blood requests',
      cols: 1,
      rows: 1,
      imageUrl: 'assets/personnel/dashboard/new-blood-request.png',
      counter: 7,
      redirect: 'personnel/blood-requests'
    }
  ];

  constructor(private service: PersonnelService) {
  }

  ngOnInit() {
    this.service.getCounterDonation().subscribe((counter: number) => this.cards[0].counter = counter);
    this.service.getCounterRequest().subscribe((counter: number) => this.cards[1].counter = counter);
  }

}
