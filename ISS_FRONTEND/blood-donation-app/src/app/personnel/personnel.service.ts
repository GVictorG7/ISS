import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Donation} from '../core/model/Donation';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class PersonnelService {
  private api = 'http://localhost:8090';

  constructor(private http: HttpClient) {
  }

  getRequests() {
    return this.http.get(this.api);
  }

  getDonations() {
    return this.http.get<Donation[]>(`${this.api}/donation/openDonations`);
  }

  getHealthIssues() {
    return this.http.get<string[]>(`${this.api}/donation/allHealthIssues`);
  }

  updateDonation(donation: Donation) {
    return this.http.post<Donation>(`${this.api}/donation/changeStatus`, donation, httpOptions);
  }
}
