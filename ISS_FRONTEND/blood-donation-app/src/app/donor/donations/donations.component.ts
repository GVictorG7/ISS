import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrls: ['./donations.component.css']
})
export class DonationsComponent implements OnInit {
  displayedColumns = ['position', 'date', 'status'];
  donations = [{date: 'azi', status: 'Acceptat'},
    {date: 'azi', status: 'Rejected'}];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  dataSource = new MatTableDataSource<any>(this.donations);

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  newDonation() {
    this.router.navigate(['../donation-form'], {relativeTo: this.activatedRoute});
  }
}
