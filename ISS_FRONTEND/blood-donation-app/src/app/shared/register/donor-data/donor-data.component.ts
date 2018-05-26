import {Component, Input, OnInit} from '@angular/core';
import {Donor} from '../../../core/model/Donor';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-donor-data',
  templateUrl: './donor-data.component.html',
  styleUrls: ['./donor-data.component.css']
})
export class DonorDataComponent implements OnInit {
  @Input() donor: Donor;


  constructor() {
  }

  ngOnInit() {
  }

}
