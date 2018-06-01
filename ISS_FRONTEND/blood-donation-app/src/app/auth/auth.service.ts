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
  private api: string = 'http://localhost:8090';

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<string>(`${this.api}/auth/login`, {
      username: username,
      password: password
    }, httpOptions).pipe(
      tap(token => localStorage.setItem('token', JSON.stringify(token))
      ));
  }

  checkAccount(user: User) {
    return this.http.post<any>(`${this.api}/auth/signup`, user, httpOptions);
  }

  register(account, type) {
    return this.http.post<any>(`${this.api}/${type.toLowerCase()}/save`, account, httpOptions);
  }

  getUsernames() {
    return this.http.get<string[]>(`${this.api}/auth/getUsernames`);
  }
}
