import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Donation} from '../../core/model/Donation';

@Component({
  selector: 'app-donation-details',
  templateUrl: './donation-details.component.html',
  styleUrls: ['./donation-details.component.css']
})
export class DonationDetailsComponent implements OnInit {
  @Input() donation: Donation;
  @Output() closeModal = new EventEmitter<boolean>();

  constructor() {
  }

  ngOnInit() {
  }

  close() {
    this.closeModal.emit(false);
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }

}
