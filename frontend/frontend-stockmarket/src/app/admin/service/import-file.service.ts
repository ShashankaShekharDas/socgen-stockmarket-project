import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImportFileService {

  url:string = "http://localhost:8083/import/import";

  constructor(private http:HttpClient) { }

  addFileService(file:any){
    
    let formData:FormData = new FormData();
    formData.append("file",file,file.name);

    return this.http.post(this.url,formData,{responseType:'text'});
  }
}
