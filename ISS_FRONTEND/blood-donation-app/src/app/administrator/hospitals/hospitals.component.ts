import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {Hospital} from '../../core/model/Hospital';
import {AdministratorService} from '../administrator.service';
import {checkCompleted} from '../../shared/utils/utils';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent implements OnInit {
  hospitals: Hospital[];
  hospital: Hospital = new Hospital();
  dataSource = new MatTableDataSource<Hospital>(this.hospitals);
  displayedColumns = ['position', 'name', 'address'];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private adminService: AdministratorService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.adminService.getHospitals().subscribe(hospitals => {
      this.hospitals = hospitals;
      this.dataSource.data=this.hospitals;
      this.cdr.detectChanges();
    });

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
