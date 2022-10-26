import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

export interface DialogData{
  konu:String;
  icerik:String;
  gecerlilikTarihi:String;
}

@Component({
  selector: 'admin-duyuru',
  templateUrl: './admin-duyuru.component.html',
  styleUrls: ['./admin-duyuru.component.css']
})
export class AdminDuyuruComponent {

  duyurular;
  constructor(private http:HttpClient, private dialog:MatDialog) {
    http.get("http://localhost:8080/duyurular/all")
    .subscribe(response => {
      this.duyurular = response;
    })
   }

   onDuyuruCreate(duyuru: {konu: String, icerik: String, gecerlilikTarihi: String}){
      this.http.post("http://localhost:8080/duyurular/add", duyuru)
        .subscribe(response => {
          console.log(response);
        })
        window.location.reload();
   }
  
   onDelete(id){
      this.http.delete("http://localhost:8080/duyurular/delete"+"/"+id)
        .subscribe(response =>{
          console.log(response);
        });
        window.location.reload();
   }
  
   onUpdate(duyuru){
    const dialogRef = this.dialog.open(UpdateDialog, {
      data : {
        konu : duyuru.konu,
        icerik : duyuru.icerik,
        gecerlilikTarihi : duyuru.gecerlilikTarihi,
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      this.http.put("http://localhost:8080/duyurular/update/" + duyuru.id, result)
        .subscribe(response => {
          console.log(response);
        });
      window.location.reload();
    });
   }

}

@Component({
  selector: 'app-detay-dialog',
  templateUrl: './guncelle-dialog.component.html',
  styleUrls: ['./guncelle-dialog.component.css']
})

export class UpdateDialog{
constructor(public dialogRef: MatDialogRef<UpdateDialog>,
  @Inject(MAT_DIALOG_DATA) public data:DialogData){}

  onNoClick(){
    this.dialogRef.close();
  }
}