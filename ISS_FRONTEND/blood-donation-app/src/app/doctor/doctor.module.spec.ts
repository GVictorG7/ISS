import { DoctorModule } from './doctor.module';

describe('DoctorModule', () => {
  let doctorModule: DoctorModule;

  beforeEach(() => {
    doctorModule = new DoctorModule();
  });

  it('should create an instance', () => {
    expect(doctorModule).toBeTruthy();
  });
});
