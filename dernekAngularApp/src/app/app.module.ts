import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {MatDialogModule} from '@angular/material/dialog'

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DuyurularComponent } from './duyurular/duyurular.component';
import { HaberlerComponent } from './haberler/haberler.component';
import { AdminDuyuruComponent, UpdateDialog } from './admin-duyuru/admin-duyuru.component';
import { AdminHaberComponent, UpdateHaberDialog } from './admin-haber/admin-haber.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DuyurularComponent,
    HaberlerComponent,
    AdminDuyuruComponent,
    AdminHaberComponent,
    UpdateDialog,
    UpdateHaberDialog
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas:[NO_ERRORS_SCHEMA]
})
export class AppModule { }
