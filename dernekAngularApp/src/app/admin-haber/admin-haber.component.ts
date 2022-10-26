import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData{
  konu:String;
  icerik:String;
  gecerlilikTarihi:String;
  haberUrl:String;
}
@Component({
  selector: 'admin-haber',
  templateUrl: './admin-haber.component.html',
  styleUrls: ['./admin-haber.component.css']
})
export class AdminHaberComponent {

  haberler;
  constructor(private http:HttpClient, private dialog:MatDialog) {
    http.get("http://localhost:8080/haberler/all")
    .subscribe(response => {
      this.haberler = response;
    })
  }

  onHaberCreate(haber: {konu: String, icerik: String, gecerlilikTarihi: String}){
    this.http.post("http://localhost:8080/haberler/add", haber)
      .subscribe(response => {
        console.log(response);
      })
      window.location.reload();
 }

 onDelete(id){
  this.http.delete("http://localhost:8080/haberler/delete"+"/"+id)
    .subscribe(response =>{
      console.log(response);
    });
    window.location.reload();
}

onUpdate(haber){
  const dialogRef = this.dialog.open(UpdateHaberDialog, {
    data : {
      konu : haber.konu,
      icerik : haber.icerik,
      gecerlilikTarihi : haber.gecerlilikTarihi,
      haberUrl : haber.haberUrl,
    }
  });
  dialogRef.afterClosed().subscribe(result => {
    this.http.put("http://localhost:8080/haberler/update/" + haber.id, result)
      .subscribe(response => {
        console.log(response);
      });
    window.location.reload();
  });
 }



}

@Component({
  selector: 'app-detay-dialog',
  templateUrl: './guncelle-haber-dialog.component.html',
  styleUrls: ['./guncelle-haber-dialog.component.css'],
})

export class UpdateHaberDialog{
constructor(public dialogRef: MatDialogRef<UpdateHaberDialog>,
  @Inject(MAT_DIALOG_DATA) public data:DialogData){}

  onNoClick(){
    this.dialogRef.close();
  }
}
