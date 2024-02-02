import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaComponent } from './producto/lista/lista.component';
import { HttpClientModule } from '@angular/common/http'
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NuevoComponent } from './producto/nuevo/nuevo.component';
import { FormsModule } from '@angular/forms';
import { ActualizarComponent } from './producto/actualizar/actualizar.component';
import { DetalleComponent } from './producto/detalle/detalle.component';


@NgModule({
  declarations: [
    AppComponent,
    ListaComponent,
    HeaderComponent,
    FooterComponent,
    NuevoComponent,
    ActualizarComponent,
    DetalleComponent    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
