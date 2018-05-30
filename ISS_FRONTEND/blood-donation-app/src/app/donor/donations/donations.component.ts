import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {DonorService} from '../donor.service';

@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrls: ['./donations.component.css']
})
export class DonationsComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  donations: any[];

  dataSource = new MatTableDataSource<any>(this.donations);

  displayedColumns = ['position', 'date', 'status'];

  details: any = {visible: false, donation: null};

  tooltip: any = {disabled: false, message: ''};

  constructor(private service: DonorService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.service.getDonations().subscribe(
      (donations) => {
        this.donations = donations;
        this.dataSource.data = donations;
        this.cdr.detectChanges();
        const result = this.checkDate();
        result.valid ? this.tooltip.disabled = false : this.tooltip = {
          disabled: true,
          message: `Trebuie sa treaca 6 luni dupa ultima donatie(${result.date})`
        };
      }
    );

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

  private checkDate() {
    const sixMonths = 15552000000;
    let date = '';
    const collected=this.donations.filter(donation => donation.collectionDate !== null).forEach(donation => {
      if (donation.collectionDate > date) {
        date = donation.date;
      }
    });
    if (date === '') {
      return {date: null, valid: true};
    }
    const valid = new Date().getMilliseconds() - new Date(date).getMilliseconds() > sixMonths;
    return {date, valid};
  }
}
