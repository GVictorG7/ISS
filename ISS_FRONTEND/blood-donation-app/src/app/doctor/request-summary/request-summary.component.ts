import {Component, Input, OnInit} from '@angular/core';
import {Request} from '../../core/model/Request';

@Component({
  selector: 'app-request-summary',
  templateUrl: './request-summary.component.html',
  styleUrls: ['./request-summary.component.css']
})
export class RequestSummaryComponent implements OnInit {
  @Input() request: Request;

  constructor() {
  }

  ngOnInit() {
  }

}
