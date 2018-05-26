import {Component, Input, OnInit} from '@angular/core';
import {Personnel} from '../../../core/model/Personnel';

@Component({
  selector: 'app-personnel-data',
  templateUrl: './personnel-data.component.html',
  styleUrls: ['./personnel-data.component.css']
})
export class PersonnelDataComponent implements OnInit {
  @Input() personnel: Personnel;

  constructor() {
  }

  ngOnInit() {
  }

}
