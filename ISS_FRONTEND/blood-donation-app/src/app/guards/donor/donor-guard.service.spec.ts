import { TestBed, inject } from '@angular/core/testing';

import { DonorGuardService } from './donor-guard.service';

describe('DonorGuardService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DonorGuardService]
    });
  });

  it('should be created', inject([DonorGuardService], (service: DonorGuardService) => {
    expect(service).toBeTruthy();
  }));
});
