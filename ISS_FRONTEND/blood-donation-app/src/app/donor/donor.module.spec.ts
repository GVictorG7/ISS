import { DonorModule } from './donor.module';

describe('DonorModule', () => {
  let donorModule: DonorModule;

  beforeEach(() => {
    donorModule = new DonorModule();
  });

  it('should create an instance', () => {
    expect(donorModule).toBeTruthy();
  });
});
