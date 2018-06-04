import { TestBed, inject } from '@angular/core/testing';

import { PersonnelService } from './personnel.service';

describe('PersonnelService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PersonnelService]
    });
  });

  it('should be created', inject([PersonnelService], (service: PersonnelService) => {
    expect(service).toBeTruthy();
  }));
});
