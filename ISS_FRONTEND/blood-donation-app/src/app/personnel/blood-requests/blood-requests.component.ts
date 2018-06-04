import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from '@angular/material';
import {PersonnelService} from '../personnel.service';
import {Request} from '../../core/model/Request';
import {Donor} from '../../core/model/Donor';

@Component({
  selector: 'app-blood-requests',
  templateUrl: './blood-requests.component.html',
  styleUrls: ['./blood-requests.component.css']
})
export class BloodRequestsComponent implements OnInit {
  requests: any[];
  displayedColumns = ['position', 'requestDate', 'priority', 'forPerson', 'bloodCategory', 'bloodType', 'bloodRh', 'bloodQuantity', 'status', 'actions'];
  dataSource = new MatTableDataSource<any>(this.requests);
  visible = false;
  eligibleDonors: Donor[];
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service: PersonnelService, private cdr: ChangeDetectorRef, private snackBar: MatSnackBar) {
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

  accept(request: Request) {
    this.service.acceptRequest(request).subscribe(
      () => this.snackBar.open('Request accepted successfully!', 'Ok', {duration: 3000}),
      (donors) => {
        this.eligibleDonors = donors.error;
        this.visible = true;
      }
    )
    ;
  }

  closeModal(event) {
    this.visible = event;
  }

  dateAsString(requestDate) {
    return `${requestDate.dayOfMonth} ${requestDate.month} ${requestDate.year}`;
  }


}
