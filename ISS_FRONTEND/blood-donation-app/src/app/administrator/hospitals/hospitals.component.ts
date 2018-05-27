import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Hospital} from '../../core/model/Hospital';
import {AdministratorService} from '../administrator.service';
import {checkCompleted} from '../../shared/utils/utils';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent implements OnInit {
  hospitals: Hospital[];
  hospital: Hospital = new Hospital();
  displayedColumns = ['position', 'name', 'address'];

  constructor(private adminService: AdministratorService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.adminService.getHospitals().subscribe(hospitals => this.hospitals = hospitals);
  }


  newHospital() {
    if (checkCompleted(this.hospital)) {
      this.adminService.saveHospitals(this.hospital).subscribe(
        () => {
          this.hospitals.push(this.hospital);
          this.hospitals = [...this.hospitals];
          this.cdr.detectChanges();
        }
      );
    } else {
      console.log('completeaza campurile');
    }
  }
}
