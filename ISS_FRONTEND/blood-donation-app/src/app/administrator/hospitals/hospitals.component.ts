import {Component, OnInit} from '@angular/core';
import {Hospital} from '../../core/model/Hospital';
import {AdministratorService} from '../administrator.service';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent implements OnInit {
  hospitals: Hospital[];
  hospital: Hospital = new Hospital();

  constructor(private adminService: AdministratorService) {
  }

  ngOnInit() {
    this.adminService.getHospitals().subscribe(hospitals => this.hospitals = hospitals);
  }


  newHospital() {
    this.adminService.saveHospitals(this.hospital).subscribe();
  }
}
