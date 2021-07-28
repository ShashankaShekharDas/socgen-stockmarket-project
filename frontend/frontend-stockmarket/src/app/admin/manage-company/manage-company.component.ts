import { UserAuth } from './../../entity/UserAuth';
import { Router } from '@angular/router';
import { IPO } from '../../entity/IPO';
import { CompanyServiceService } from './../service/company-service.service';
import { Company } from '../../entity/Company';
import { Component, OnInit } from '@angular/core';
import { Director } from '../../entity/Director';
import { Sector } from './Sector';

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

  directors:Director[] = [];

  deleteDirectorIndex:number = 0;

  sectors:Sector[] = [];

  deleteSectorIndex:number = 0;

  tempp?:any;

  auth?:UserAuth;


  constructor(private router:Router,private companyService:CompanyServiceService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("session") == null){
      this.router.navigate(['/login']);
    }
    this.auth = JSON.parse(sessionStorage.getItem("session")!);
    if(!this.auth?.admin)this.router.navigate(['/login']);
    this.viewCompany();
    this.addDirector();
    this.addSector();
    
  }

  addCompany(){
    this.companyService.addCompanyService(this.details).subscribe(data => console.log(data));
  }

  deleteCompany(){
    this.companyService.deleteCompanyService(this.deleteDirectorIndex).subscribe(data=>console.log(data));
  }

  async viewCompany(){
   this.getDetails = await this.companyService.viewCompanyService(123).toPromise();
  }

  addIPODb(){
    this.companyService.addIPOService(this.addIPO).subscribe(data=>console.log(data));
  }

  updateIPODb(){
    this.companyService.updateIPOService(this.updateIPO).subscribe(data=>console.log(data));
  }

  addDirector(){
    
    this.directors.push(
      {
        companyCode:-1,
        directorName:""
      }
    );
  }

  addSector(){
    
    this.sectors.push(
      {
        company:-1,
        sectorId:""
      }
    );
  }

  addDirectorsDB(){
    for (var i:number = 1; i < this.directors.length; i++) {
      this.directors[i].companyCode = this.directors[0].companyCode;
    }
    this.companyService.addDirectorService(this.directors).subscribe(data=>console.log(data));
    
  }
  addSectorsDB(){
    for (var i:number = 1; i < this.sectors.length; i++) {
      this.sectors[i].company = this.sectors[0].company;
    }
    this.companyService.addSectorService(this.sectors).subscribe(data=>console.log(data));
  }

  deleteDirectorByIndex(i:any){
    if(this.directors.length == 1)
    {
      console.log('Only 1 element remaining, cant delete');
      
      return;
    }
    
    this.directors.splice(i,1);
  }

  deleteSectorByIndex(i:any){
    if(this.sectors.length == 1)
    {
      console.log('Only 1 element remaining, cant delete');
      
      return;
    }
    
    this.sectors.splice(i,1);
  }

  

  
}
