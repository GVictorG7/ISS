import {Component, Input, OnInit} from '@angular/core';
import {Doctor} from '../../../core/model/Doctor';
import {Hospital} from '../../../core/model/Hospital';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-doctor-data',
  templateUrl: './doctor-data.component.html',
  styleUrls: ['./doctor-data.component.css']
})
export class DoctorDataComponent implements OnInit {
  @Input() doctor: Doctor;
  hospitals: Hospital[];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get<Hospital[]>('http://localhost:8090/hospitals/getHospitals').subscribe(
      hospitals => this.hospitals = hospitals,
      (err) => console.log(err)
    );
  }

}
