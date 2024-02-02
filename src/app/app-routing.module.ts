import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Producto } from './model/producto';
import { ListaComponent } from './producto/lista/lista.component';
import { NuevoComponent } from './producto/nuevo/nuevo.component';
import { ActualizarComponent } from './producto/actualizar/actualizar.component';
import { DetalleComponent } from './producto/detalle/detalle.component';

const routes: Routes = [
  {path : 'producto',component:ListaComponent},
  {path :'', redirectTo:'producto',pathMatch:'full'},
  {path : 'producto/nuevo',component:NuevoComponent},
  {path : 'producto/:id',component:ActualizarComponent},
  {path : 'detalle/:id',component:DetalleComponent},
  {path : 'actualizar/:id',component:ActualizarComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
