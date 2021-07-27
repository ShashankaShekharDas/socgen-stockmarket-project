import { IPO } from './../../entity/IPO';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from 'src/app/entity/Company';
import { Director } from 'src/app/entity/Director';
import { Sector } from 'src/app/entity/Sector';
import { Stock } from 'src/app/entity/Stock';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  url:string = "http://localhost:8081/companyDetail";

  constructor(private http:HttpClient) { }

  getCompanyData(code:number){
    return this.http.get<Company>(this.url+"/company/specific/"+code);
  }

  getDirectorData(code:number){
    return this.http.get<Director[]>(this.url+"/company/director/"+code);
  }

  getSectorData(code:number)
  {
    return this.http.get<Sector[]>(this.url+"/company/company/sector/"+code);
  }
  
  getPeriodData(code:number,from:string,to:string,period:number,exchange:string){
    // return this.http.get  this.url+"/"
    return this.http.get<Stock[]>(this.url+"/company/"+code+"/"+exchange+"/"+from+"/"+to+"/"+period);
  }

  getIPO(){
    return this.http.get<IPO[]>(this.url+"/IPO/chronology");
  }

}
