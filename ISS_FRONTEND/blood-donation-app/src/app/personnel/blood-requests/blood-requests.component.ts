import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {PersonnelService} from '../personnel.service';

@Component({
  selector: 'app-blood-requests',
  templateUrl: './blood-requests.component.html',
  styleUrls: ['./blood-requests.component.css']
})
export class BloodRequestsComponent implements OnInit {
  requests: any[];
  displayedColumns = ['position', 'requestDate', 'bloodCategory', 'bloodType', 'bloodRh', 'bloodQuantity', 'status'];
  dataSource = new MatTableDataSource<any>(this.requests);
  details: any = {visible: false, request: null};
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service: PersonnelService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.service.getRequests().subscribe(
      (requests: any[]) => {
        this.requests = requests;
        this.dataSource.data = this.requests;
        this.cdr.detectChanges();
      }
    );

  }

  showDetails(request) {
    if (this.details.request && this.details.request.date === request.date) {
      this.details.visible = !this.details.visible;
    } else {
      this.details.visible = true;
      this.details.request = request;
    }
  }
}
