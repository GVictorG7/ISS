import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Request} from '../../core/model/Request';

@Component({
  selector: 'app-request-summary',
  templateUrl: './request-summary.component.html',
  styleUrls: ['./request-summary.component.css']
})
export class RequestSummaryComponent implements OnInit {
  @Input() request: Request;
  @Output() closeRequestDetails = new EventEmitter<boolean>();

  constructor() {
  }

  ngOnInit() {
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }

  close() {
    this.closeRequestDetails.emit(false);
  }
}
