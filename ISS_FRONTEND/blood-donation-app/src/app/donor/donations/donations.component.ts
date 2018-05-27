import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrls: ['./donations.component.css']
})
export class DonationsComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;


  donations = [{date: 'azi', status: 'Acceptat'},
    {date: 'ieri', status: 'Rejected'}];

  dataSource = new MatTableDataSource<any>(this.donations);

  displayedColumns = ['position', 'date', 'status'];

  details: any = {visible: false, donation: null};

  tooltip: any = {disabled: false, message: ''};

  constructor(private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    setTimeout(() => this.tooltip.message = 'mesaj', 2000);

  }

  newDonation() {
    this.router.navigate(['../donation-form'], {relativeTo: this.activatedRoute});
  }

  showDetails(donation) {
    const donationDetails = {status: donation.status, date: donation.date, healthIssues: ['cancer', 'holera', 'gonoree']};
    if (this.details.donation && this.details.donation.date === donationDetails.date) {
      this.details.visible = !this.details.visible;
    } else {
      this.details.visible = true;
      this.details.donation = donationDetails;
    }
  }

}
