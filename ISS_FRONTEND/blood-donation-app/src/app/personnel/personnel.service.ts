import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Donation} from '../core/model/Donation';
import {Request} from '../core/model/Request';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class PersonnelService {
  private api = 'http://localhost:8090';

  constructor(private http: HttpClient) {
  }

  getRequests() {
    return this.http.get(`${this.api}/request/getRequestsOpen`);
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

  acceptRequest(request: Request) {
    return this.http.post<any>(`${this.api}/request/modifyRequest`, request, httpOptions);
  }

  sendMails(strings: string[]) {
    return this.http.post<any>(`${this.api}/notify/donors/mail`, strings, httpOptions);
  }

  getCounterDonation() {
    return this.http.get(`${this.api}/donation/openDonationsCounter`);
  }

  getCounterRequest() {
    return this.http.get(`${this.api}/donation/openDonationsCounter`);
  }

  getBloodCounter() {
    return this.http.get(`${this.api}/blood/getCounter`);
  }
}
