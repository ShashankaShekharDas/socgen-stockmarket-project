import { Router } from '@angular/router';
import { UserAuth } from './../../entity/UserAuth';
import { ManageExchangeService } from './../service/manage-exchange.service';
import { Component, OnInit } from '@angular/core';
import { exchange } from './exchange';

@Component({
  selector: 'app-manage-exchange',
  templateUrl: './manage-exchange.component.html',
  styleUrls: ['./manage-exchange.component.css']
})
export class ManageExchangeComponent implements OnInit {

  id:string="";
  name:string="";
  brief:string="";
  remarks:string="";
  addExchangeRet?:any;
  auth?:UserAuth;
  
  constructor(private router:Router,private manageExchangeService:ManageExchangeService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("session") == null){
      this.router.navigate(['/login']);
    }
    this.auth = JSON.parse(sessionStorage.getItem("session")!);
    if(!this.auth?.admin)this.router.navigate(['/login']);
    
  }

  addExchange(){
    this.manageExchangeService.addExchangeService(this.id,this.name,this.brief,this.remarks).subscribe(data => this.addExchangeRet = data);
    console.log(this.addExchangeRet);
    
  }

  deleteExchange(){
    this.manageExchangeService.deleteExchangeService(this.id).subscribe(data => console.log(data));
  }

}
