import {AfterViewInit, ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Donor} from '../../../core/model/Donor';
import {MatPaginator, MatSnackBar, MatSort, MatTableDataSource} from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';
import {PersonnelService} from '../../personnel.service';

@Component({
  selector: 'app-blood-request-status',
  templateUrl: './blood-request-status.component.html',
  styleUrls: ['./blood-request-status.component.css']
})
export class BloodRequestStatusComponent implements OnInit, AfterViewInit {
  @Input() donors: Donor[];
  @Output() closeModal = new EventEmitter<boolean>();
  dataSource = new MatTableDataSource<Donor>(this.donors);
  displayedColumns = ['select', 'position', 'lastName', 'firstName', 'phone', 'email'];
  selection = new SelectionModel<Donor>(true, []);
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private service: PersonnelService, private cdr: ChangeDetectorRef, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    if (this.donors) {
      this.dataSource.data = this.donors;
    }
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.selection.select(row));
  }

  sendMails() {
    this.service.sendMails(this.selection.selected.map(donor => donor.email)).subscribe(
      () => {
        this.snackBar.open('Donors notified succesfully!', 'Ok', {duration: 3000});
        this.close();
      },
      () => {
        this.snackBar.open('Something went wrong. Sorry!', 'Ok', {duration: 3000});
        this.close();
      }
    );
  }

  close() {
    this.closeModal.emit(false);
  }


}
