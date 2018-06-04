import {Component, OnInit} from '@angular/core';
import {User} from '../../core/model/User';
import {checkCompleted} from '../../shared/utils/utils';
import {MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';
import {AdministratorService} from '../administrator.service';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {
  user: User = {id: 0, username: '', password: '', userType: null};
  person: any = {id: 0};
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  constructor(private adminService: AdministratorService, private snackBar: MatSnackBar, private router: Router) {
  }

  ngOnInit() {
  }

  saveAccount() {
    if (!checkCompleted(this.user) || !checkCompleted(this.person)) {
      this.snackBar.open('Fields completed incorrectly!', 'Ok', {duration: 1000});
    } else {
      this.adminService.checkAccount(this.user).subscribe(
        (userId) => {
          this.user.id = userId;
          this.person.userId = userId;
          this.adminService.register(this.person, this.user.userType).subscribe(
            () => {
              this.snackBar.open('Saved succesfully!', 'Ok', {duration: 3000});
              this.router.navigateByUrl('home');
            },
            () => this.snackBar.open('Fields completed wrong!', 'Ok', {duration: 3000})
          );
        },
        () => this.snackBar.open('Username already in use !', 'Ok', {duration: 3000})
      );
    }
  }

}
