import {Injectable} from '@angular/core';
import {CanLoad, Route, Router} from '@angular/router';

@Injectable()
export class DoctorGuardService implements CanLoad {
  constructor(private router: Router) {
  }

  canLoad(route: Route): boolean {
    const token = JSON.parse(localStorage.getItem('token'));
    if (token.userType === 'DOCTOR') {
      return true;
    }
    this.router.navigate(['home']);
    return false;
  }
}
