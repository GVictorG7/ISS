import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {tap} from 'rxjs/operators';
import {User} from '../core/model/User';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AuthService {
  private authUrl: string = 'http://localhost:8090/auth';

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<string>(`${this.authUrl}/login`, {
      username: username,
      password: password
    }, httpOptions).pipe(
      tap(token => localStorage.setItem('token', JSON.stringify(token))
      ));
  }

  checkAccount(user: User) {
    return this.http.post<any>(`${this.authUrl}/signup`, user, httpOptions);
  }

  register(account, type) {
    return this.http.post<any>(`http://localhost:8090/${type.toLowerCase()}/save`, account, httpOptions);
  }
}
