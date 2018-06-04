import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodRequestStatusComponent } from './blood-request-status.component';

describe('BloodRequestStatusComponent', () => {
  let component: BloodRequestStatusComponent;
  let fixture: ComponentFixture<BloodRequestStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BloodRequestStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodRequestStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
