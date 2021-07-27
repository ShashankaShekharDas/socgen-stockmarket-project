import { UserAuth } from './../../entity/UserAuth';
import { Router } from '@angular/router';
import { ImportFileService } from './../service/import-file.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-import-data',
  templateUrl: './import-data.component.html',
  styleUrls: ['./import-data.component.css']
})
export class ImportDataComponent implements OnInit {

  file?:File;
  auth?:UserAuth;

  constructor(private router:Router,private importService:ImportFileService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem("session") == null){
      this.router.navigate(['/login']);
    }
    this.auth = JSON.parse(sessionStorage.getItem("session")!);
    if(!this.auth?.admin)this.router.navigate(['/login']);
    
  }

  addFile(){
    this.importService.addFileService(this.file).subscribe(data=>console.log(data));
  }

  addFiles(event:any){
    this.file = event.target.files[0];
  }

}
