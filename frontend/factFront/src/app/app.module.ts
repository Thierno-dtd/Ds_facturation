import { ErrorHandler, NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicModule } from '@ionic/angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificateComponent } from './pages/authentificate/authentificate.component';
import { HomeoutComponent } from './pages/homeout/homeout.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthentificateComponent,
    HomeoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    IonicModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
