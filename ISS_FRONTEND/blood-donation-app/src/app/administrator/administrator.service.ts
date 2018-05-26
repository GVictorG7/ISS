import {Injectable} from '@angular/core';
import {User} from '../core/model/User';
import {HttpClient, HttpHeaders} from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable()
export class AdministratorService {

  constructor(private http: HttpClient) {
  }

  checkAccount(user: User) {
    return this.http.post<any>(`http://localhost:8090/auth/signup`, user, httpOptions);
  }

  register(account, type) {
    return this.http.post<any>(`http://localhost:8090/${type.toLowerCase()}/save`, account, httpOptions);
  }
}
