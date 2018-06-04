import { TestBed, inject } from '@angular/core/testing';

import { PersonnelGuardService } from './personnel-guard.service';

describe('PersonnelGuardService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PersonnelGuardService]
    });
  });

  it('should be created', inject([PersonnelGuardService], (service: PersonnelGuardService) => {
    expect(service).toBeTruthy();
  }));
});
