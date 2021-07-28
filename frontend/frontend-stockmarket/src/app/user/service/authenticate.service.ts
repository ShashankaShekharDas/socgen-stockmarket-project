import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuth } from 'src/app/entity/UserAuth';
import { User } from '../login/user';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  url:string = "http://localhost:8084/authentication/auth";

  constructor(private http:HttpClient) { }

  authenticate(user:User){
    return this.http.post<UserAuth>(this.url,user);
  }
}
