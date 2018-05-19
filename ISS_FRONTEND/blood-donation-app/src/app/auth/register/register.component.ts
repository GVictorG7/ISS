import {Component, OnInit} from '@angular/core';
import {Person} from "../../core/model/Person";
import {AuthService} from "../auth.service";
import {MatSnackBar} from "@angular/material";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  person: Person = {
    id: null,
    firstName: '',
    lastName: '',
    password: '',
    cnp: '',
    gender: '',
    personType: ''
  };
  roles = [{value: 'DONOR', viewValue: 'Donator'},
    {value: 'PERSONNEL', viewValue: 'Personal centru de donatie'},
    {value: 'DOCTOR', viewValue: 'Doctor'}
  ];

  constructor(private authService: AuthService, private snackBar: MatSnackBar, private router: Router) {
  }

  ngOnInit() {
  }

  register() {
    if (this.person.personType === '')
      this.snackBar.open("Date completate gresit!", 'Ok', {duration: 1000});
    else
      this.authService.register(this.person).subscribe(
        () => this.router.navigateByUrl('home'),
        () => this.snackBar.open("Date completate gresit!", 'Ok', {duration: 1000})
      )
  }
}
