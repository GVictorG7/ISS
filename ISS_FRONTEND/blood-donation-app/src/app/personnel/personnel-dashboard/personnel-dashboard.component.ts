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
      imageUrl: 'https://png.kisspng.com/20180331/jhq/kisspng-heart-rate-blood-donation-pulse-donation-blood-5abf4b58afa173.0345391415224861047194.png',
      counter: 2
    },
    {
      title: 'New blood requests',
      cols: 1,
      rows: 1,
      imageUrl: 'https://cdn0.iconfinder.com/data/icons/hand-color/100/Hand__5-512.png',
      counter: 7
    }
  ];

  constructor(private service: PersonnelService) {
  }

  ngOnInit() {
    this.service.getCounterDonation().subscribe(counter => this.cards[0].counter = counter);
    this.service.getCounterRequest().subscribe(counter => this.cards[1].counter = counter);
  }

}
