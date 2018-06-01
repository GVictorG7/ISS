import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {PersonnelService} from '../personnel.service';
import {Donation} from '../../core/model/Donation';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit {
  donations: Donation[];
  displayedColumns = ['position', 'date', 'status', 'action'];
  dataSource = new MatTableDataSource<Donation>(this.donations);
  details: any = {visible: false, donation: null};
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service: PersonnelService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.service.getDonations().subscribe(
      (donations: Donation[]) => {
        this.donations = donations;
        this.dataSource.data = this.donations;
        this.cdr.detectChanges();
      }
    );
  }

  showDetails(donation: Donation) {
    if (this.details.donation && this.details.donation.requestdate === donation.requestDate) {
      this.details.visible = !this.details.visible;
    } else {
      this.details.visible = true;
      this.details.donation = JSON.parse(JSON.stringify(donation));
    }
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }

}
