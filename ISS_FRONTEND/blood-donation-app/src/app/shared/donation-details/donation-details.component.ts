import {Component, Input, OnInit} from '@angular/core';
import {Donation} from '../../core/model/Donation';

@Component({
  selector: 'app-donation-details',
  templateUrl: './donation-details.component.html',
  styleUrls: ['./donation-details.component.css']
})
export class DonationDetailsComponent implements OnInit {
  @Input() donation: Donation;

  constructor() {
  }

  ngOnInit() {
  }

}
