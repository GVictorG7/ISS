import {Component, OnInit} from '@angular/core';
import {User} from '../../core/model/User';
import {AuthService} from '../auth.service';
import {MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';
import {UserType} from '../../core/model/UserType';
import {Donor} from '../../core/model/Donor';
import {checkCompleted} from '../../shared/utils/utils';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = {id: 0, username: '', password: '', userType: UserType.DONOR};
  donor: Donor = {
    id: 0,
    firstName: '',
    lastName: '',
    cnp: '',
    gender: '',
    birthday: '',
    address: '',
    localAddress: '',
    email: '',
    phone: '',
    userId: 0
  };

  constructor(private authService: AuthService, private snackBar: MatSnackBar, private router: Router) {
  }

  ngOnInit() {
  }


  register() {
    if (!checkCompleted(this.user) || !checkCompleted(this.donor)) {
      this.snackBar.open('Date completate gresit!', 'Ok', {duration: 1000});
    } else {
      this.authService.checkAccount(this.user).subscribe(
        (userId) => {
          this.user.id = userId;
          this.donor.userId = userId;
          this.authService.register(this.donor, this.user.userType).subscribe(
            () => this.router.navigateByUrl('home'),
            () => this.snackBar.open('Date personale completate gresit!', 'Ok', {duration: 1000})
          );
        },
        () => this.snackBar.open('Nume de utilizator deja folosit!', 'Ok', {duration: 1000})
      );
    }
  }
}
