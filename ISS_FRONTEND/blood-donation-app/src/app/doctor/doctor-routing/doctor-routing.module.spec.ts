import { DoctorRoutingModule } from './doctor-routing.module';

describe('DoctorRoutingModule', () => {
  let doctorRoutingModule: DoctorRoutingModule;

  beforeEach(() => {
    doctorRoutingModule = new DoctorRoutingModule();
  });

  it('should create an instance', () => {
    expect(doctorRoutingModule).toBeTruthy();
  });
});
