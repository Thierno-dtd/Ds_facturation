import { Component, OnInit } from '@angular/core';

declare var require: any;
@Component({
  selector: 'app-authentificate',
  templateUrl: './authentificate.component.html',
  styleUrls: ['./authentificate.component.css']
})
export class AuthentificateComponent implements OnInit {

  isActive: boolean = false;

  toggleActive(value: boolean): void {
    this.isActive = value;
  }
  ngOnInit() {


  }
}
