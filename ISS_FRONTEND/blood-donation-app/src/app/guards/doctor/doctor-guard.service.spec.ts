import { TestBed, inject } from '@angular/core/testing';

import { DoctorGuardService } from './doctor-guard.service';

describe('DoctorGuardService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DoctorGuardService]
    });
  });

  it('should be created', inject([DoctorGuardService], (service: DoctorGuardService) => {
    expect(service).toBeTruthy();
  }));
});
