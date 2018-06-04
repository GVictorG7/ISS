import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {Hospital} from '../../core/model/Hospital';
import {AdministratorService} from '../administrator.service';
import {checkCompleted} from '../../shared/utils/utils';
import {MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from '@angular/material';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

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

  formGroup: FormGroup;

  constructor(private snackBar: MatSnackBar,
              private formBuilder: FormBuilder,
              private adminService: AdministratorService,
              private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.adminService.getHospitals().subscribe(hospitals => {
      this.hospitals = hospitals;
      this.dataSource.data = this.hospitals;
      this.cdr.detectChanges();
    });
    this.buildForm();
  }


  newHospital() {
    this.adminService.saveHospitals(this.hospital).subscribe(
      () => {
        this.snackBar.open('Hospital saved succesfully!', 'Ok', {duration: 3000});
        this.hospitals.push(JSON.parse(JSON.stringify(this.hospital)));
        this.hospitals = [...this.hospitals];
        this.cdr.detectChanges();
      },
      (err) => this.snackBar.open('Hospital save succesfully!', 'Ok', {duration: 3000})
    );
  }

  private buildForm() {
    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required]
    });
  }
}
