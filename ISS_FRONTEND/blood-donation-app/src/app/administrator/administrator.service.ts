import {Injectable} from '@angular/core';
import {User} from '../core/model/User';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Hospital} from '../core/model/Hospital';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AdministratorService {
  private api = 'htpp://localhost:8090';

  constructor(private http: HttpClient) {
  }

  getHospitals() {
    return this.http.get <Hospital[]>(`${this.api}/hospitals/getAll`);
  }

  checkAccount(user: User) {
    return this.http.post<any>(`${this.api}/auth/signup`, user, httpOptions);
  }

  register(account, type) {
    return this.http.post<any>(`${this.api}/${type.toLowerCase()}/save`, account, httpOptions);
  }

  saveHospitals(hospital: Hospital) {
    return this.http.post<any>(`${this.api}/hospitals/save`, hospital, httpOptions);
  }
}
