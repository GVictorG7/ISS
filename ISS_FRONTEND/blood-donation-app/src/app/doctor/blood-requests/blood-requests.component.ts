import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {DoctorService} from '../doctor.service';
import {Request} from '../../core/model/Request';

@Component({
  selector: 'app-blood-requests',
  templateUrl: './blood-requests.component.html',
  styleUrls: ['./blood-requests.component.css']
})
export class BloodRequestsComponent implements OnInit {
  requests: Request[];
  dataSource = new MatTableDataSource<Request>(this.requests);
  displayedColumns = ['position', 'requestDate', 'priority', 'person', 'bloodCategory', 'bloodQuantity', 'bloodType', 'bloodRH', 'status', 'actions'];
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  visibleNew = false;
  visibleDetails = false;
  request: Request;

  constructor(private service: DoctorService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.service.getRequests().subscribe(
      (requests: Request[]) => {
        this.requests = requests;
        this.dataSource.data = this.requests;
        this.cdr.detectChanges();
      }
    );
  }

  newRequest() {
    this.visibleNew = !this.visibleNew;
  }

  viewChanged(event) {
    this.visibleNew = event;
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }

  showSummary(request) {
    this.request = request;
    this.visibleDetails = !this.visibleDetails;
  }
}
