import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DoctorService} from '../doctor.service';
import {Request} from '../../core/model/Request';
import {AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators} from '@angular/forms';

@Component({
  selector: 'app-new-blood-request',
  templateUrl: './new-blood-request.component.html',
  styleUrls: ['./new-blood-request.component.css']
})
export class NewBloodRequestComponent implements OnInit {
  @Output() viewChanged = new EventEmitter<boolean>();
  request: Request = new Request();
  priorities = ['NORMAL', 'HIGH', 'LOW'];
  types = ['O', 'A', 'B', 'AB'];
  rhs = ['POSITIVE', 'NEGATIVE'];
  categories = ['WHOLE', 'PLASMA', 'THROMBOCYTE', 'REDCELL'];

  formGroup: FormGroup;

  constructor(private service: DoctorService, private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formGroup = this.formBuilder.group({
      bloodType: ['', Validators.required],
      bloodCategory: ['', Validators.required],
      bloodRH: ['', Validators.required],
      bloodQuantity: ['', [Validators.required, this.checkPositive()]],
      forPerson: ['', Validators.required],
      priority: ['', Validators.required]
    });
  }

  saveRequest() {
    this.service.newRequest(this.request).subscribe(
      () => this.viewChanged.emit(false)
    );
  }

  cancel() {
    this.viewChanged.emit(false);
  }

  private checkPositive(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      const n = control.value;
      return n > 0 ? null : {'message': {value: null}};
    };
  }
}
