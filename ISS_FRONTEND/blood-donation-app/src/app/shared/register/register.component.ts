import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../core/model/User';
import {MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';
import {UserType} from '../../core/model/UserType';

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

  constructor(private snackBar: MatSnackBar, private router: Router) {
  }

  ngOnInit() {
  }
}
