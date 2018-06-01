import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../core/model/User';
import {MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';
import {UserType} from '../../core/model/UserType';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  @Input() user: User = {id: 0, username: '', password: '', userType: null};
  @Input() person: any = {};
  roles = [{value: UserType.DONOR, viewValue: 'Donator'},
    {value: UserType.PERSONNEL, viewValue: 'Personal centru de donatie'},
    {value: UserType.DOCTOR, viewValue: 'Doctor'}
  ];
  role = new FormControl('', [Validators.required]);
  @Input() firstFormGroup: FormGroup;
  @Input() secondFormGroup: FormGroup;

  constructor(private snackBar: MatSnackBar, private router: Router, private _formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
}
