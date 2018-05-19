import { Component, OnInit } from '@angular/core';
import {Person} from "../core/model/Person";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loggedUser:Person=null;
  constructor() { }

  ngOnInit() {
    this.verifyLoggedUser();
  }

  private verifyLoggedUser() {
    let token=JSON.parse(localStorage.getItem('token'));
    if(token)
      this.loggedUser={id:token.id,firstName:token.firstname,personType:token.personType};
    else
      this.loggedUser=null;
  }

}
