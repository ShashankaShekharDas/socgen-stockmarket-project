import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { ManageCompanyComponent } from './admin/manage-company/manage-company.component';
import { ImportDataComponent } from './admin/import-data/import-data.component';

@NgModule({
  declarations: [
    AppComponent,
    ManageExchangeComponent,
    ManageCompanyComponent,
    ImportDataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
