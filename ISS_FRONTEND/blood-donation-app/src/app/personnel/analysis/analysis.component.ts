import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {PersonnelService} from '../personnel.service';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit {
  donations: any[];
  displayedColumns = ['position', 'date', 'status'];
  dataSource = new MatTableDataSource<any>(this.donations);
  details: any = {visible: false, donation: null};
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service: PersonnelService, private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.service.getDonations().subscribe(
      (donations: any[]) => {
        this.donations = donations;
        this.dataSource.data = this.donations;
        this.cdr.detectChanges();
      }
    );
  }

  showDetails(donation) {
    if (this.details.donation && this.details.donation.date === donation.date) {
      this.details.visible = !this.details.visible;
    } else {
      this.details.visible = true;
      this.details.donation = donation;
    }
  }

}
