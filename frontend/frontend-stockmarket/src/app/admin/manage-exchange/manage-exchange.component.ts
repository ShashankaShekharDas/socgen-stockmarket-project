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
  
  constructor(private manageExchangeService:ManageExchangeService) { }

  ngOnInit(): void {
    
  }

  addExchange(){
    this.manageExchangeService.addExchangeService(this.id,this.name,this.brief,this.remarks).subscribe(data => this.addExchangeRet = data);
    console.log(this.addExchangeRet);
    
  }

  deleteExchange(){
    this.manageExchangeService.deleteExchangeService(this.id).subscribe(data => console.log(data));
  }

}
