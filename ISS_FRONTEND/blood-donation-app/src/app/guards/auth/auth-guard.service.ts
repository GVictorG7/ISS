import {Injectable} from '@angular/core';
import {CanLoad, Route, Router} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable()
export class AuthGuardService implements CanLoad {

  constructor(private router: Router) {
  }

  canLoad(route: Route): Observable<boolean> | Promise<boolean> | boolean {
    const token = localStorage.getItem('token');
    if (!token) {
      return true;
    }
    this.router.navigate(['home']);
    return false;
  }
}
