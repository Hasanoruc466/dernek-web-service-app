import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'dernekAngularApp';
  i = 1;
  kullaniciDuyuru = true;
  kullaniciHaber = false;
  adminHaber = false;
  adminDuyuru = false;
  kullanici(){
    this.i=1;
    this.kullaniciHaber = false;
    this.adminDuyuru = false;
    this.adminHaber = false;
    this.kullaniciDuyuru = true;
  }
  admin(){
    this.i = 2;
    this.kullaniciHaber = false;
    this.adminDuyuru = true;
    this.adminHaber = false;
    this.kullaniciDuyuru = false;
  }
  duyuru(){
    if(this.i == 1){
      this.kullaniciHaber = false;
      this.adminDuyuru = false;
      this.adminHaber = false;
      this.kullaniciDuyuru = true;
    }
    else if(this.i == 2){
      this.kullaniciHaber = false;
      this.adminDuyuru = true;
      this.adminHaber = false;
      this.kullaniciDuyuru = false;
    }
  }
  haber(){
    if(this.i == 1){
      this.kullaniciHaber = true;
      this.adminDuyuru = false;
      this.adminHaber = false;
      this.kullaniciDuyuru = false;
    }
    else if(this.i == 2){
      this.kullaniciHaber = false;
      this.adminDuyuru = false;
      this.adminHaber = true;
      this.kullaniciDuyuru = false;
    }
  }
}
