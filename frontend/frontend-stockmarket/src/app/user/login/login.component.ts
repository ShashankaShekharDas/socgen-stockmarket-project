import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuth } from 'src/app/entity/UserAuth';
import { AuthenticateService } from '../service/authenticate.service';
import { User } from './user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  user:User = {
    username:"",
    password:""
  }  
  a = 1;
  b = 1;

  constructor(private auth:AuthenticateService,private router:Router) { }

  ngOnInit(): void {
    // whenever comes to login page previous session is invalidated
    sessionStorage.removeItem("session");

  }
  storeSession(data:UserAuth){
    sessionStorage.setItem("session",JSON.stringify(data));
    this.router.navigate(['/users']);
  }

  authenticate(){
    // Storing authentication data in localstorage
    localStorage.setItem("session","");
    this.auth.authenticate(this.user).subscribe((data:UserAuth)=>this.storeSession(data));
  }

}
