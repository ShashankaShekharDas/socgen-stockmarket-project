import { UpdateDetailsService } from './../service/update-details.service';
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
  username:string = "";
  password:string = "";
  constructor(private router:Router,private updateDetails:UpdateDetailsService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("session") == null){
      this.router.navigate(['/']);
    }
    
    this.auth = JSON.parse(sessionStorage.getItem("session")!);
    this.username = this.auth!.username;
    
  }

  updatePassword(){
    this.updateDetails.updatePassword(this.username,this.password).subscribe(data=>console.log(data));
  }


}
