import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare var require: any;


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent implements OnInit {
  title = 'facturationFront';

  constructor(private router: Router) {}

  navigateToAuthentificate() {
    this.router.navigate(['/authentificate']);}

  ngOnInit(){
    require('../js.js');

  }
}
