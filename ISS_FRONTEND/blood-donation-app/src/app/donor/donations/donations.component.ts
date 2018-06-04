import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
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

  donationForm: boolean;

  constructor(private service: DonorService,
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
            message: `You have pending donation to complete`
          };
        } else {
          const result = this.checkDate();
          result.valid ? this.tooltip.disabled = false : this.tooltip = {
            disabled: true,
            message: `6 months have to pass after the last donation(${this.dateAsString(result.date)})`
          };
        }
      }
    );

  }

  newDonation() {
    this.donationForm = true;
  }

  showDetails(donation: Donation) {
    this.details.visible = true;
    this.details.donation = donation;
  }

  closeModal(event) {
    this.details.visible = event;
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

  closeNewDonation(event) {
    this.donationForm = event;
  }

  private checkOpen() {
    return this.donations.find(donation => donation.status === 'OPEN');
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }

}
