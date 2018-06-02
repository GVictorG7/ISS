import {Donor} from './Donor';

export class Donation {
  id = 0;
  requestDate: any;
  collectionDate: any;
  forPerson = '';
  status = '';
  bloodRH = '';
  bloodType = '';
  healthIssues: string[] = [];
  donor: Donor;
}
