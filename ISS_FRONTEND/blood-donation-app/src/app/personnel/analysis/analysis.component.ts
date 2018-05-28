import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit {
  donations = [{date: 'azi', status: 'DESCHIS', healthIssues: [], blood: {id: 0, category: '', RH: '', type: ''}},
    {date: 'ieri', status: 'RESPINS', healthIssues: ['gonoree'], blood: {id: 0, category: '', RH: '', type: ''}}];
  displayedColumns = ['position', 'date', 'status'];
  dataSource = new MatTableDataSource<any>(this.donations);
  details: any = {visible: false, donation: null};
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor() {
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
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
