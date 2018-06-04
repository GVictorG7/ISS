import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnelDashboardComponent } from './personnel-dashboard.component';

describe('PersonnelDashboardComponent', () => {
  let component: PersonnelDashboardComponent;
  let fixture: ComponentFixture<PersonnelDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonnelDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonnelDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
