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
        return [{title: 'Analize', path: 'personnel/analysis'},
          {title: 'Cereri sange', path: 'personnel/blood-requests'}
        ];
      }
      case 'DOCTOR': {
        return [{title: 'Cereri sange', path: 'doctor/blood-requests'}
        ];
      }
      case 'DONOR': {
        return [{title: 'Donatii', path: 'donor/donations'}];
      }
      case 'ADMIN': {
        return [{title: 'Spitale', path: 'administrator/hospitals'},
          {title: 'Inregistrare conturi', path: 'administrator/accounts'}
        ];
      }

    }
  }

  onLogout($event) {
    localStorage.removeItem('token');

  }
}
