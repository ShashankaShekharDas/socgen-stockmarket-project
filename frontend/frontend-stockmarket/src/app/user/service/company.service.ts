import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from 'src/app/entity/Company';
import { Director } from 'src/app/entity/Director';
import { Sector } from 'src/app/entity/Sector';

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
}
