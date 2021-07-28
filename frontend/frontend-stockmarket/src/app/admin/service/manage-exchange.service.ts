import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { stringify } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class ManageExchangeService {
  url:string = "http://localhost:8090/exchange/exchange/";

  constructor(private http:HttpClient) { }
  addExchangeService(id:string,name:string,brief:string,remarks:string)
  {
    
    const exchangeAdd =  {
      "id":id,
      "name":name,
      "brief":brief,
      "remarks":remarks
    };

    return this.http.post(this.url+"add",exchangeAdd,
    {responseType: 'text'});
  }

  getExchangeService(){
    return this.http.get(this.url,
      {responseType: 'text'});
  }

  deleteExchangeService(id:string){
    return this.http.delete(this.url+id,
      {responseType: 'text'});
  }
}
