import { LogoutComponent } from './user/logout/logout.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule,Routes } from '@angular/router';
import { ImportDataComponent } from './admin/import-data/import-data.component';
import { ManageCompanyComponent } from './admin/manage-company/manage-company.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { CompanyComponent } from './user/company/company.component';
import { LoginComponent } from './user/login/login.component';
import { UsersComponent } from './user/users/users.component';

const routes:Routes = [
  {path:'import',component:ImportDataComponent},
  {path:'manageCompany',component:ManageCompanyComponent},
  {path:'manageExchange',component:ManageExchangeComponent},
  {path:'company',component:CompanyComponent},
  {path:'',component:LoginComponent},
  {path:'users',component:UsersComponent},
  {path:"logout",component:LogoutComponent}
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
