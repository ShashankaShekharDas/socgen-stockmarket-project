import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/entity/Company';
import { Director } from 'src/app/entity/Director';
import { CompanyService } from '../service/company.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companyCode:number = 0;
  companyDetails:Company = {
    code:0,
    name:"X",
    turnover:0,
    ceo:"X",
    about:"X",
    listed:false
  }
  director:Director[] = [];

  constructor(private companyService:CompanyService) { }

  ngOnInit(): void {
    
  } 
  getCompanyData(){
    this.companyDetails = {
      code:0,
      name:"X",
      turnover:0,
      ceo:"X",
      about:"X",
      listed:false
    }
    this.director = []
    this.companyService.getCompanyData(this.companyCode).subscribe((data:Company)=>this.companyDetails = data);
    this.getDirectorData();
  }

  getDirectorData(){
    this.companyService.getDirectorData(this.companyCode).subscribe((data:Director[])=>this.director=data);
  }

}
