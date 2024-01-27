import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicModule } from '@ionic/angular';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificateComponent } from './page/authentificate/authentificate.component';
import { HomeoldComponent } from './page/homeold/homeold.component';
import { HomeComponent } from './page/home/home.component';
import { ProduitComponent } from './page/produit/produit.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthentificateComponent,
    HomeoldComponent,
    HomeComponent,
    ProduitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    IonicModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
