import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {tap} from "rxjs/operators";
import {Person} from "../core/model/Person";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AuthService {
  private authUrl: string = 'http://localhost:8090/auth';

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    console.log('entered login functin');
    return this.http.post<string>(`${this.authUrl}/login`, {
      username: username,
      password: password
    }, httpOptions).pipe(
      tap(token => localStorage.setItem('token', JSON.stringify(token))
      ));
  }

  register(person: Person) {
    return this.http.post<Person>(`${this.authUrl}/signup`, person, httpOptions);
  }
}
