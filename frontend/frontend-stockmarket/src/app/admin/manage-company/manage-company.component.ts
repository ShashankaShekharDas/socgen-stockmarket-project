import { IPO } from './IPO';
import { CompanyServiceService } from './../service/company-service.service';
import { Company } from './Company';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manage-company',
  templateUrl: './manage-company.component.html',
  styleUrls: ['./manage-company.component.css']
})
export class ManageCompanyComponent implements OnInit {

  details:Company = {
    code:0,
    name:"",
    turnover:0,
    ceo:"",
    about:"",
    listed:false
  };

  getDetails:Company = {
    code:0,
    name:"",
    turnover:0,
    ceo:"",
    about:"",
    listed:false
  }

  addIPO:IPO = {
    id:0,
    price:0,
    countShares:0,
    openingDateTime:"2020-01-01T00:00:00",
    remarks:"",
    exchangeId:"",
    companyId:0
  }
  updateIPO:IPO = {
    id:0,
    price:0,
    countShares:0,
    openingDateTime:"2020-01-01T00:00:00",
    remarks:"",
    exchangeId:"",
    companyId:0
  }

  deleteCode:number = 0;
  tempp?:any;

  a:number = 1;

  constructor(private companyService:CompanyServiceService) { }

  ngOnInit(): void {
    this.viewCompany();
    
  }

  addCompany(){
    this.companyService.addCompanyService(this.details).subscribe(data => console.log(data));
  }

  deleteCompany(){
    this.companyService.deleteCompanyService(this.deleteCode).subscribe(data=>console.log(data));
  }

  setup(data:Company){
    this.details.code = data.code;
    this.details.name = data.name;
    this.details.turnover = data.turnover;
    this.details.ceo = data.ceo;
    this.details.about = data.about;
    this.details.listed = data.listed;

    return this.details;
    
  }

  async viewCompany(){
   this.getDetails = await this.companyService.viewCompanyService(123).toPromise();
  }

  addIPODb(){
    this.companyService.addIPOService(this.addIPO).subscribe(data=>console.log(data));
  }

  updateIPODb(){

  }
}
