import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'duyurular',
  templateUrl: './duyurular.component.html',
  styleUrls: ['./duyurular.component.css']
})
export class DuyurularComponent  {

 
  duyurular;
  constructor(private http:HttpClient) {
      http.get("http://localhost:8080/duyurular/all")
        .subscribe(response => {
          this.duyurular = response;
        });
   }

   
  

}
