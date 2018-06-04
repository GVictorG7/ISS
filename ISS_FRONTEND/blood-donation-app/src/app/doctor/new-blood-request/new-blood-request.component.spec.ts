import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewBloodRequestComponent } from './new-blood-request.component';

describe('NewBloodRequestComponent', () => {
  let component: NewBloodRequestComponent;
  let fixture: ComponentFixture<NewBloodRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewBloodRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewBloodRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
