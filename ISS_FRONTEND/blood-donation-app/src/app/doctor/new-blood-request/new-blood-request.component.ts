import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DoctorService} from '../doctor.service';

@Component({
  selector: 'app-new-blood-request',
  templateUrl: './new-blood-request.component.html',
  styleUrls: ['./new-blood-request.component.css']
})
export class NewBloodRequestComponent implements OnInit {
  @Input() request: any = {
    person: '',
    requestDate: new Date(),
    priority: 0,
    bloodCategory: 'Integral',
    bloodRh: 'Pozitiv',
    bloodType: 'A',
    quantity: 0
  };
  @Output() viewChanged = new EventEmitter<boolean>();
  types = ['0', 'A', 'B', 'AB'];
  rhs = ['Pozitiv', 'Negativ'];
  categories = ['Integral', 'Plasma', 'Trombocite', 'Globule rosii'];

  constructor(private service: DoctorService) {
  }

  ngOnInit() {
  }

  saveRequest() {
    this.service.newRequest(this.request).subscribe(
      () => this.viewChanged.emit(false)
    );
  }

  cancel() {
    this.viewChanged.emit(false);
  }

}
