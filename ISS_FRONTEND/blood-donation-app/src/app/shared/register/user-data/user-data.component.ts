import {Component, Input, OnInit} from '@angular/core';
import {UserType} from '../../../core/model/UserType';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.css']
})
export class UserDataComponent implements OnInit {
  @Input() type: UserType;
  @Input() person: any = {};
  @Input() formValidation: FormGroup;
  constructor() {
  }

  ngOnInit() {
  }

}
