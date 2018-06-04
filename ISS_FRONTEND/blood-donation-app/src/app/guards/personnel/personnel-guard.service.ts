import { Injectable } from '@angular/core';
import {CanLoad, Route, Router} from '@angular/router';

@Injectable()
export class PersonnelGuardService implements CanLoad{
  constructor(private router: Router) {
  }

  canLoad(route: Route): boolean {
    const token = JSON.parse(localStorage.getItem('token'));
    if (token.userType === 'PERSONNEL') {
      return true;
    }
    this.router.navigate(['home']);
    return false;
  }
}
