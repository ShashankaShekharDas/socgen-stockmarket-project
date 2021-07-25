import { ImportFileService } from './../service/import-file.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-import-data',
  templateUrl: './import-data.component.html',
  styleUrls: ['./import-data.component.css']
})
export class ImportDataComponent implements OnInit {

  file?:File;

  constructor(private importService:ImportFileService) { }

  ngOnInit(): void {
  }

  addFile(){
    this.importService.addFileService(this.file).subscribe(data=>console.log(data));
  }

  addFiles(event:any){
    this.file = event.target.files[0];
  }

}
