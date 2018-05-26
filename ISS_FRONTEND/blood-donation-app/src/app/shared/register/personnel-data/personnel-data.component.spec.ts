import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonnelDataComponent } from './personnel-data.component';

describe('PersonnelDataComponent', () => {
  let component: PersonnelDataComponent;
  let fixture: ComponentFixture<PersonnelDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonnelDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonnelDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
