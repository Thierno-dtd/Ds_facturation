import { Component, OnInit } from '@angular/core';
declare var require: any;

@Component({
  selector: 'app-homeold',
  templateUrl: './homeold.component.html',
  styleUrls: ['./homeold.component.less']
})
export class HomeoldComponent implements OnInit {
  constructor(){}
  ngOnInit(){
  require('../../../js.js');
  }

}
