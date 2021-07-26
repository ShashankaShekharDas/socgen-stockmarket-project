import { IPO } from './../manage-company/IPO';
import { Company } from './../manage-company/Company';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Director } from '../manage-company/Director';
import { Sector } from '../manage-company/Sector';

@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {

  url:string = "http://localhost:8081/companyDetail/";
  details:Company = {
    code:0,
    name:"",
    turnover:0,
    ceo:"",
    about:"",
    listed:false
  };

  constructor(private http:HttpClient) { }

  addCompanyService(company:Company){
    return this.http.post(this.url+"company/add",company,{responseType: 'text'});
  }

  deleteCompanyService(code:number){
    return this.http.delete(this.url+"company/"+code,{responseType:"text"});
  }

  viewCompanyService(code:number){
    return this.http.get<Company>(this.url+"company/specific/"+code);
  }

  addIPOService(ipo:IPO){
    return this.http.post(this.url+"IPO",ipo,{responseType:"text"});
  }

  updateIPOService(ipo:IPO){
    return this.http.post(this.url+"IPO/update",ipo,{responseType:"text"})
  }

  addDirectorService(directors:Director[])
  {
    return this.http.post(this.url+"company/director",directors,{responseType:"text"});
  }
  addSectorService(sectors:Sector[])
  {
    return this.http.post(this.url+"company/sector",sectors,{responseType:"text"});
  }
}
