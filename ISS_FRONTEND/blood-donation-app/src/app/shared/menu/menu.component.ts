import {Component, OnInit} from '@angular/core';
import {Person} from "../../core/model/Person";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  loggedUser: Person = null;
  mainMenuItems: any[] = [];

  constructor() {
  }

  ngOnInit() {
    this.verifyLoggedUser();
  }

  private verifyLoggedUser() {
    let token = JSON.parse(localStorage.getItem('token'));
    if (token) {
      this.loggedUser = token;
      this.mainMenuItems.push(...this.getMenuItems(this.loggedUser.personType));
    }
    else {
      this.loggedUser = null;
      this.mainMenuItems.push({title:'Logare',path:'auth/login'},
        {title:'Inregistrare',path:'auth/register'}
        );
    }
  }

  private getMenuItems(personType: string) {
    switch (personType) {
      case 'PERSONNEL': {
        return [{title: 'Analize', path: 'personnel/analysis'},
          {title: 'Cereri sange', path: 'personnel/blood-requests'}
        ]
      }
      case 'DOCTOR': {
        return [{title: 'Cereri sange', path: 'doctor/blood-requests'}
        ]
      }
      case 'DONOR': {
        return [{title: 'Donatii', path: 'donor/donations'}];
      }

    }
  }

  onLogout($event) {
    localStorage.removeItem('token');

  }
}
