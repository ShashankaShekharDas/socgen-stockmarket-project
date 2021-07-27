import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UpdateDetailsService {

  url:string = "http://localhost:8084/authentication/register/update";

  constructor(private http:HttpClient) { }

  updatePassword(username:string,password:string){
    var ob = {
      'username':username,
      'password':password
    };
    return this.http.post(this.url,ob,{responseType:"text"});
  }
}
