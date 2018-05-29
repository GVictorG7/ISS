import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class DoctorService {
  private api = 'http://localhost:8090';
  private doctor = JSON.parse(localStorage.getItem('token')).userData;

  constructor(private http: HttpClient) {
  }

  newRequest(request) {
    request.idDoctor = this.doctor.id;
    return this.http.post(`${this.api}/doctor/request`, request, httpOptions);
  }

  getRequests() {
    return this.http.get(`${this.api}/doctor/getRequests`, {params: {id: this.doctor.id}});
  }
}
