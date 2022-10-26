
import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';


export interface DialogData{
  konu:String;
  icerik:String;
  tarih:String;
  haberUrl:String;
}

@Component({
  selector: 'haberler',
  templateUrl: './haberler.component.html',
  styleUrls: ['./haberler.component.css']
})
export class HaberlerComponent {

  haberler;
  
  constructor(private http:HttpClient, public dialog:MatDialog) { 
    http.get("http://localhost:8080/haberler/all")
        .subscribe(response => {
          this.haberler = response;
          console.log(response);
        });
  }

  detay(i) : void{
    
    this.haberler.forEach(haber => {
      if(i == haber.id){
        const dialogRef = this.dialog.open(Dialog, {
          width : '250px',
          data : {
            konu : haber.konu,
            icerik : haber.icerik,
            tarih : haber.gecerlilikTarihi,
            haberUrl : haber.haberUrl,
          }
        });
      }
    });
        
  }

 
}

 @Component({
    selector: 'app-detay-dialog',
    templateUrl: './detay-dialog.component.html',
    styleUrls: ['./detay-dialog.component.css']
  })

export class Dialog{
  constructor(public dialogRef: MatDialogRef<Dialog>,
    @Inject(MAT_DIALOG_DATA) public data:DialogData){}
}