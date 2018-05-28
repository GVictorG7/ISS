import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-blood-requests',
  templateUrl: './blood-requests.component.html',
  styleUrls: ['./blood-requests.component.css']
})
export class BloodRequestsComponent implements OnInit {
  requests = [{date: 'azi', status: 'DESCHIS', bloodType: 'AB', bloodCategory: 'Plasma', bloodRH: 'Pozitiv', quantity: 1},
    {date: 'ieri', status: 'RESPINS', bloodType: '0', bloodCategory: 'Trombocite', bloodRH: 'Negativ', quantity: 2}];
  displayedColumns = ['position', 'date', 'category', 'type', 'rh', 'quantity', 'status'];
  dataSource = new MatTableDataSource<any>(this.requests);
  details: any = {visible: false, request: null};
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor() {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  showDetails(request) {
    if (this.details.request && this.details.request.date === request.date) {
      this.details.visible = !this.details.visible;
    } else {
      this.details.visible = true;
      this.details.request = request;
    }
  }
