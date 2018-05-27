import { PersonnelRoutingModule } from './personnel-routing.module';

describe('PersonnelRoutingModule', () => {
  let personnelRoutingModule: PersonnelRoutingModule;

  beforeEach(() => {
    personnelRoutingModule = new PersonnelRoutingModule();
  });

  it('should create an instance', () => {
    expect(personnelRoutingModule).toBeTruthy();
  });
});
