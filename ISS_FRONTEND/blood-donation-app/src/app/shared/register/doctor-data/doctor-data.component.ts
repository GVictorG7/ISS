import {Component, Input, OnInit} from '@angular/core';
import {Doctor} from '../../../core/model/Doctor';
import {Hospital} from '../../../core/model/Hospital';
import {HttpClient} from '@angular/common/http';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-doctor-data',
  templateUrl: './doctor-data.component.html',
  styleUrls: ['./doctor-data.component.css']
})
export class DoctorDataComponent implements OnInit {
  @Input() doctor: Doctor;
  @Input() formValidation: FormGroup;
  hospitals: Hospital[];
  hValidator = new FormControl('', [Validators.required]);

  constructor(private http: HttpClient, private _formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.http.get<Hospital[]>('http://localhost:8090/hospitals/getHospitals').subscribe(
      hospitals => this.hospitals = hospitals,
      (err) => console.log(err)
    );
    this.formValidation = this._formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required]
    });
  }

}
