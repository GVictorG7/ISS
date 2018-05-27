import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonationRejectedReasonsComponent } from './donation-rejected-reasons.component';

describe('DonationRejectedReasonsComponent', () => {
  let component: DonationRejectedReasonsComponent;
  let fixture: ComponentFixture<DonationRejectedReasonsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonationRejectedReasonsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonationRejectedReasonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
