import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {DonationForm} from '../core/model/DonationForm';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class DonorService {
  private api = 'http://localhost:8090';
  private donor = JSON.parse(localStorage.getItem('token')).userData;

  constructor(private http: HttpClient) {
  }

  saveDonation(donation: DonationForm) {
    return this.http.post<any>(`${this.api}/donation/save`, {idDonor: this.donor.id}, httpOptions);
  }

  getDonations() {
    return this.http.get<any>(`${this.api}/donation/allDonations/${this.donor.id}`);
  }
}
