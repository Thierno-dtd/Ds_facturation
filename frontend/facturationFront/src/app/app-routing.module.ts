import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthentificateComponent } from './page/authentificate/authentificate.component';
import { HomeoldComponent } from './page/homeold/homeold.component';
import { HomeComponent } from './page/home/home.component';

const routes: Routes = [
  {path : "authentificate", component:AuthentificateComponent},
  {path : "homme", component:HomeoldComponent},
  {path : "home", component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
