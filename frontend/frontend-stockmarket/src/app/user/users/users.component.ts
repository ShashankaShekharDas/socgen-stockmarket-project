import { Component, OnInit } from '@angular/core';
import { UserAuth } from 'src/app/entity/UserAuth';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  auth?:UserAuth;
  constructor(private router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("session") == null){
      this.router.navigate(['/users']);
    }
    else{
      console.log(456);
    }
  }

}
