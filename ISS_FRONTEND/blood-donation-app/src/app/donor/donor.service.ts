import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DonationForm} from "../core/model/DonationForm";

@Injectable()
export class DonorService {

  constructor(private http: HttpClient) {
  }

  saveDonation(donation: DonationForm) {
    console.log(donation);
  }
}
