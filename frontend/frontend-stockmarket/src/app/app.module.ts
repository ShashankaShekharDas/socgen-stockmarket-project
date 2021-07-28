import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { GoogleChartsModule } from 'angular-google-charts';


import { AppComponent } from './app.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { ManageCompanyComponent } from './admin/manage-company/manage-company.component';
import { ImportDataComponent } from './admin/import-data/import-data.component';
import { LoginComponent } from './user/login/login.component';
import { CompanyComponent } from './user/company/company.component';
import { UsersComponent } from './user/users/users.component';
import { AppRoutingModule } from './app-routing.module';
import { NgApexchartsModule } from 'ng-apexcharts';
import { LogoutComponent } from './user/logout/logout.component';
import { NavbarComponent } from './navbar/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    ManageExchangeComponent,
    ManageCompanyComponent,
    ImportDataComponent,
    LoginComponent,
    CompanyComponent,
    UsersComponent,
    LogoutComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgApexchartsModule,
    GoogleChartsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
