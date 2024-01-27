import { Component,OnInit } from '@angular/core';
import { ProduitControllerService} from './'
declare var require: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit{
  constructor(private produitController: ProduitControllerService){
    
  }
    ngOnInit(){
    require('../../../js.js');
    this.produitController.
    }
}
