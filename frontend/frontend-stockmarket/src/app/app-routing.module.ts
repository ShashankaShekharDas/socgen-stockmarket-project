import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule,Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ImportDataComponent } from './admin/import-data/import-data.component';
import { ManageCompanyComponent } from './admin/manage-company/manage-company.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { CompanyComponent } from './user/company/company.component';
import { LoginComponent } from './user/login/login.component';
import { UsersComponent } from './user/users/users.component';

const routes:Routes = [
  {path:'',component:HomeComponent},
  {path:'import',component:ImportDataComponent},
  {path:'manageCompany',component:ManageCompanyComponent},
  {path:'manageExchange',component:ManageExchangeComponent},
  {path:'company',component:CompanyComponent},
  {path:'login',component:LoginComponent},
  {path:'users',component:UsersComponent},
];

@NgModule({
  exports:[RouterModule],
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
