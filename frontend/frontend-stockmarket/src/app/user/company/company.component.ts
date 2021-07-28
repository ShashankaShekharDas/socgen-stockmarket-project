import { UserAuth } from './../../entity/UserAuth';
import { Router } from '@angular/router';
import { IPO } from './../../entity/IPO';
import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/entity/Company';
import { Director } from 'src/app/entity/Director';
import { Sector } from 'src/app/entity/Sector';
import { Stock } from 'src/app/entity/Stock';
import { CompanyService } from '../service/company.service';
import { ChartType, Row } from "angular-google-charts";


@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companyCode:number = 0;
  companyCode2:number = 0;
  companyDetails:Company = {
    code:0,
    name:"X",
    turnover:0,
    ceo:"X",
    about:"X",
    listed:false
  }
  director:Director[] = [];
  sector:Sector[] = [];
  period:number = 5;

  fromTime:string = "2020-01-01T00:00:00";
  fromTime2:string = "2020-01-01T00:00:00";
  toTime:string = "2020-01-01T00:00:00";
  toTime2:string = "2020-01-01T00:00:00";
  exchangeID:string="";
  exchangeID2:string="";
  stock:Stock[] = [];
  stock2:Stock[] = [];
  ipo:IPO[] = [];

  // pagination
  pageSize:number = 2;
  index:number = 0;

  p1:number = 0;
  p2:number = 1;
  p3:number = 2;
  numberOfPages:number = 0;
  pageNumber:number = 1;
  
  disabled1:boolean = true;
  disabled2:boolean = false;
  disabled3:boolean = false;

  // Credentials
  auth?:UserAuth;
  usernameUser?:string;
  constructor(private router:Router,private companyService:CompanyService) { }

  // Charts
  // Data in date,value format
  chart = {
    "title":"Price in given range for",
    "type":ChartType.LineChart,
    "data":[
      ["test",1]
    ],
    "columnNames":['Date', 'Price'],
    "options":{},
    "width":1500,
    "height":500
  }
  chart2 = {
    "title":"Price in given range for",
    "type":ChartType.LineChart,
    "data":[
      ["test",1]
    ],
    "columnNames":['Date', 'Price'],
    "options":{},
    "width":1500,
    "height":500
  }

  combinedChart = {
    "title":"Combined Price in given range for ",
    "type":ChartType.LineChart,
    "data":[
      ["2000-01-01T00:00:00",0,0]
    ],
    "columnNames":['Date', 'Price 1','Price 2'],
    "options":{},
    "width":1500,
    "height":500
  }
  combinedCharts:boolean = false;

  ngOnInit(): void {
    if(sessionStorage.getItem("session") == null){
      this.router.navigate(['/users']);
    }
    this.auth = JSON.parse(sessionStorage.getItem("session")!);
    this.usernameUser = this.auth!.username;
    
    this.getIPOs();
    
  } 
  getCompanyData(){
    this.companyDetails = {
      code:0,
      name:"X",
      turnover:0,
      ceo:"X",
      about:"X",
      listed:false
    }
    this.director = []
    this.companyService.getCompanyData(this.companyCode).subscribe((data:Company)=>this.companyDetails = data);
    this.getDirectorData();
    this.getSectorData();
  }

  getDirectorData(){
    this.companyService.getDirectorData(this.companyCode).subscribe((data:Director[])=>this.director=data);
    
  }
  
  getSectorData(){
    this.companyService.getSectorData(this.companyCode).subscribe((data:Sector[])=>this.sector = data);
  }

  combineChart(){
    console.log(Math.max(this.chart.data.length,this.chart2.data.length));
    
    for(let i = 0;i < Math.max(this.chart.data.length,this.chart2.data.length);i++){
      this.combinedChart.data.push([this.chart.data[i][0],this.chart.data[i][1],100]);
    }

  }

  setCharts(data:Stock[],nm:boolean){

    if(nm)
    {
      this.stock = data;
      // Format date-price
      var tempData:any = [];

      for(let i = 0;i < this.stock.length;i++)
        tempData.push([this.stock[i].dateTime,this.stock[i].price]);
      
      this.chart.data = tempData;
      
    }
    else{
      this.stock2 = data;
      var tempData:any = [];

      for(let i = 0;i < this.stock2.length;i++)
        tempData.push([this.stock2[i].dateTime,this.stock2[i].price]);
      
      this.chart2.data = tempData;
      this.combineChart();
    }
  }

  getPeriodData(){
    this.companyService.getPeriodData(this.companyCode,this.fromTime,this.toTime,this.period,this.exchangeID).subscribe((data:Stock[])=>this.setCharts(data,true));
  }

  getPeriodData2(){
    this.companyService.getPeriodData(this.companyCode,this.fromTime,this.toTime,this.period,this.exchangeID).subscribe((data:Stock[])=>this.setCharts(data,true));
    this.companyService.getPeriodData(this.companyCode2,this.fromTime2,this.toTime2,this.period,this.exchangeID).subscribe((data:Stock[])=>this.setCharts(data,false));
  }

  startPagination(data:IPO[]){
    this.ipo = data;
    var newIPO = {
      id:134,
      price:250,
      countShares:1000,
      openingDateTime:"2022-08-27T13:39:18.712",
      remarks:"qwertyu",
      exchangeId:"NSE",
      companyId:789456
    };
    this.ipo.push(newIPO)
    this.ipo.push(newIPO)
    this.ipo.push(newIPO)
    this.ipo.push(newIPO)
    this.ipo.push(newIPO)
    this.ipo.push(newIPO)
    this.ipo.push(newIPO)
    

    this.numberOfPages = Math.ceil(this.ipo.length/this.pageSize);
    if(this.numberOfPages == 2)
    {
      this.disabled3 = true;
    }
    if(this.numberOfPages == 1){
      this.disabled2 = true;
      this.disabled3 = true;
    }
  }
  getIPOs(){
    this.companyService.getIPO().subscribe((data:IPO[])=>this.startPagination(data));
  }

  checkValidPage(){
    this.disabled3 = this.index+this.pageSize >= this.ipo.length;
  }
  fixBottomIndexes(){
    this.p2 = this.pageNumber;
    this.p1 = this.pageNumber-1;
    this.p3 = this.pageNumber+1;
  }

  incrementIndex(){
    
    if(this.index < this.ipo.length-this.pageSize){
      this.index += this.pageSize;
      this.pageNumber += 1;
      this.fixBottomIndexes();
    }
    this.checkValidPage();
  }
  decrementIndex(){
    if(this.index >= this.pageSize ){
      this.index -=this.pageSize;
      this.pageNumber -= 1;
      this.fixBottomIndexes();

    }
    this.checkValidPage();
  }

  changePage(goTo:number){
    this.pageNumber = goTo;
    this.index = goTo*this.pageSize;
    this.fixBottomIndexes();
    this.checkValidPage();
    
  }

  
}
