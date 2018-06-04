import {Component, Input, OnInit} from '@angular/core';
import {Donor} from '../../../core/model/Donor';
import {MatSnackBar} from '@angular/material';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-donor-data',
  templateUrl: './donor-data.component.html',
  styleUrls: ['./donor-data.component.css']
})
export class DonorDataComponent implements OnInit {
  @Input() donor: Donor;
  @Input() formValidation: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.formValidation = this._formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      cnp: ['', [Validators.required, Validators.maxLength(13), Validators.minLength(13)]],
      gender: ['', Validators.required],
      birthday: ['', Validators.required],
      address: ['', Validators.required],
      localAddress: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required]
    });
  }

}
