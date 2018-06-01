import {Component, Input, OnInit} from '@angular/core';
import {Personnel} from '../../../core/model/Personnel';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-personnel-data',
  templateUrl: './personnel-data.component.html',
  styleUrls: ['./personnel-data.component.css']
})
export class PersonnelDataComponent implements OnInit {
  @Input() personnel: Personnel;
  @Input() formValidation: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formValidation = this._formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required]
    });
  }

}
