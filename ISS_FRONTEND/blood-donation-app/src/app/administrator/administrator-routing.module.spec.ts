import { AdministratorRoutingModule } from './administrator-routing.module';

describe('AdministratorRoutingModule', () => {
  let administratorRoutingModule: AdministratorRoutingModule;

  beforeEach(() => {
    administratorRoutingModule = new AdministratorRoutingModule();
  });

  it('should create an instance', () => {
    expect(administratorRoutingModule).toBeTruthy();
  });
});
