import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {DoctorService} from '../doctor.service';

@Component({
  selector: 'app-blood-requests',
  templateUrl: './blood-requests.component.html',
  styleUrls: ['./blood-requests.component.css']
})
export class BloodRequestsComponent implements OnInit {
  requests;
  dataSource = new MatTableDataSource<any>(this.requests);
  displayedColumns = ['position', 'requestDate', 'priority', 'person', 'bloodCategory', 'bloodQuantity', 'bloodType', 'bloodRH', 'status'];
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  visible = false;
  request: any = {
    person: '',
    requestDate: new Date(),
    priority: 0,
    bloodCategory: 'Integral',
    bloodRh: 'Pozitiv',
    bloodType: 'A',
    quantity: 0
  };

  constructor(private service: DoctorService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.service.getRequests().subscribe(
      (requests: any[]) => {
        this.requests = requests;
        this.dataSource.data = this.requests;
        this.cdr.detectChanges();
      }
    );
  }

  newRequest() {
    this.visible = !this.visible;
  }

  viewChanged(event) {
    this.visible = event;
  }

}
