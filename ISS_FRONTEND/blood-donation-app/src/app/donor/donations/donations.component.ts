import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {DonorService} from '../donor.service';
import {Donation} from '../../core/model/Donation';

@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrls: ['./donations.component.css']
})
export class DonationsComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  donations: Donation[];

  dataSource = new MatTableDataSource<Donation>(this.donations);

  displayedColumns = ['position', 'date', 'status', 'action'];

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
        if (this.checkOpen()) {
          this.tooltip = {
            disabled: true,
            message: `Aveti donatii in asteptare`
          };
        } else {
          const result = this.checkDate();
          result.valid ? this.tooltip.disabled = false : this.tooltip = {
            disabled: true,
            message: `Trebuie sa treaca 6 luni dupa ultima donatie(${this.dateAsString(result.date)})`
          };
        }
      }
    );

  }

  newDonation() {
    this.router.navigate(['../donation-form'], {relativeTo: this.activatedRoute});
  }

  showDetails(donation: Donation) {
    if (this.details.donation && this.details.donation.requestDate === donation.requestDate) {
      this.details.visible = !this.details.visible;
    } else {
      this.details.visible = true;
      this.details.donation = donation;
    }
  }

  private checkDate() {
    const sixMonths = 15552000000;
    let date = '';
    const collected = this.donations.filter(donation => donation.collectionDate !== null).forEach(donation => {
      if (donation.collectionDate > date) {
        date = donation.requestDate;
      }
    });
    console.log(date);
    if (date === '') {
      return {date: null, valid: true};
    }
    const valid = new Date().getMilliseconds() - new Date(date).getMilliseconds() > sixMonths;
    return {date, valid};
  }

  private checkOpen() {
    return this.donations.find(donation => donation.status === 'OPEN');
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }

}
