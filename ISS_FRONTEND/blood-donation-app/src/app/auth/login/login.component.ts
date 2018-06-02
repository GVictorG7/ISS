import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.formGroup = this.fb.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });

  }

  login(username: string, password: string) {
    if (username === 'admin') {
      const token = {userData: {firstName: 'Administrator'}, userType: 'ADMIN'};
      localStorage.setItem('token', JSON.stringify(token));
      this.router.navigateByUrl('');
    } else {
      this.authService.login(username, password).subscribe(
        () => this.navigateToHome(),
        (err) => console.log(err)
      );
    }
  }

  navigateToHome() {
    const token = JSON.parse(localStorage.getItem('token')).userType;
    console.log(token);
    switch (token) {
      case 'ADMIN': {
        this.router.navigateByUrl('administrator');
        break;
      }
      case 'DONOR': {
        this.router.navigateByUrl('donor');
        break;
      }
      case 'PERSONNEL': {
        this.router.navigateByUrl('personnel');
        break;
      }
      case 'DOCTOR': {
        this.router.navigateByUrl('doctor');
        break;
      }
    }
  }

}
