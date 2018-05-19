import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private authService:AuthService,private router:Router) { }

  ngOnInit() {
    console.log('login oninit');


  }

  login(username:string,password:string){
    this.authService.login(username,password).subscribe(
      ()=> this.router.navigateByUrl(''),
      (err)=>console.log(err)
    )
  }

}
