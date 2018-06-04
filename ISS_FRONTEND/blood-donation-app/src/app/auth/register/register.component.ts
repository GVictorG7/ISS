import {Component, OnInit} from '@angular/core';
import {User} from '../../core/model/User';
import {AuthService} from '../auth.service';
import {MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';
import {UserType} from '../../core/model/UserType';
import {Donor} from '../../core/model/Donor';
import {checkCompleted} from '../../shared/utils/utils';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = {id: 0, username: '', password: '', userType: UserType.DONOR};
  donor: Donor = new Donor();
  usernames: string[] = ['adrian'];
  formGroup: FormGroup;
  dataFormGroup: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private snackBar: MatSnackBar, private router: Router) {
  }

  ngOnInit() {
    this.authService.getUsernames().subscribe(usernames => this.usernames = usernames);
    this.formGroup = this.formBuilder.group({
      username: ['', [Validators.required, this.checkUsername()]],
      password: ['', Validators.required]
    });
  }


  register() {
    if (!checkCompleted(this.user) || !checkCompleted(this.donor)) {
      this.snackBar.open('Fields completed incorrectly!', 'Ok', {duration: 3000});
    } else {
      this.authService.checkAccount(this.user).subscribe(
        (userId) => {
          this.user.id = userId;
          this.donor.userId = userId;
          this.authService.register(this.donor, this.user.userType).subscribe(
            () => {
              this.snackBar.open('Account created! Please login!', 'Ok', {duration: 3000});
              this.router.navigateByUrl('home');
            },
            () => this.snackBar.open('Fields completed incorrectly!', 'Ok', {duration: 3000})
          );
        },
        () => this.snackBar.open('Username taken!', 'Ok', {duration: 3000})
      );
    }
  }

  private checkUsername() {
    return (control: AbstractControl): { [key: string]: any } => {
      const username = this.usernames.find(user => user === control.value);
      return username ? {'username': {value: null}} : null;

    };
  }
}
