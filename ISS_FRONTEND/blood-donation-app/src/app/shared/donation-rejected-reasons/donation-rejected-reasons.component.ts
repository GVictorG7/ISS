import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-donation-rejected-reasons',
  templateUrl: './donation-rejected-reasons.component.html',
  styleUrls: ['./donation-rejected-reasons.component.css']
})
export class DonationRejectedReasonsComponent implements OnInit {
  @Input() donation: any = {status: 'Respins', date: '2018-05-04', healthIssues: ['cancer', 'holera', 'gonoree']};

  constructor() {
  }

  ngOnInit() {
  }

}
