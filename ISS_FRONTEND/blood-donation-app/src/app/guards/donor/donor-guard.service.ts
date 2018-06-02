import {Injectable} from '@angular/core';
import {Route, Router} from '@angular/router';

@Injectable()
export class DonorGuardService {

  constructor(private router: Router) {
  }

  canLoad(route: Route): boolean {
    const token = JSON.parse(localStorage.getItem('token'));
    if (token.userType === 'DONOR') {
      return true;
    }
    this.router.navigate(['home']);
    return false;
  }
}
