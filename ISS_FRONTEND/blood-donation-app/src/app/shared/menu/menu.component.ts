import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  loggedUser: any = null;
  mainMenuItems: any[] = [];

  constructor() {
  }

  ngOnInit() {
    this.verifyLoggedUser();
  }

  private verifyLoggedUser() {
    const token = JSON.parse(localStorage.getItem('token'));
    if (token) {
      this.loggedUser = token;
      this.mainMenuItems.push(...this.getMenuItems(this.loggedUser.userType));
    } else {
      this.loggedUser = null;
      this.mainMenuItems.push({title: 'Logare', path: 'auth/login'},
        {title: 'Inregistrare', path: 'auth/register'}
      );
    }
  }

  private getMenuItems(personType: string) {
    switch (personType) {
      case 'PERSONNEL': {
        return [{title: 'Dashboard', path: 'personnel/dashboard'},
          {title: 'Donations analysis', path: 'personnel/analysis'},
          {title: 'Blood requests', path: 'personnel/blood-requests'},
          {title: 'Blood bank statistics', path: 'personnel/blood-bank'}
        ];
      }
      case 'DOCTOR': {
        return [{title: 'Blood requests', path: 'doctor/blood-requests'}
        ];
      }
      case 'DONOR': {
        return [{title: 'Donations', path: 'donor/donations'}];
      }
      case 'ADMIN': {
        return [{title: 'Hospitals', path: 'administrator/hospitals'},
          {title: 'Accounts register', path: 'administrator/accounts'}
        ];
      }

    }
  }

  onLogout($event) {
    localStorage.removeItem('token');

  }
}
