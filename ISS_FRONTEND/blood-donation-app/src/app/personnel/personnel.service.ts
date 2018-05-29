import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class PersonnelService {
  private api = 'http://localhost:8090';

  constructor(private http: HttpClient) {
  }

  getRequests() {
    return this.http.get(this.api);
  }
}
