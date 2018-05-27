export class Address {
  address = '';
  city = '';
  county = '';
}

export class DonationForm {
  firstName = '';
  lastName = '';
  birthday = '';
  address: Address = new Address();
  localAddress: Address = new Address();
  email = '';
  phone = '';
}
