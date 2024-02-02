import { Component ,OnInit} from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Producto } from 'src/app/model/producto';
import { Tipo } from 'src/app/model/tipo';
import { ProductoService } from 'src/app/servicio/producto.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent  implements OnInit{
 id:string;
 //idTipo:string
 tipo: Tipo = new Tipo();
 producto: Producto = new Producto();
 constructor(private productoService:ProductoService, private route:ActivatedRoute,private router:Router){}

 ngOnInit(): void {
     this.id = (this.route.snapshot.paramMap.get('id') as string);     
     this.productoService.obtenerProducto(this.id).subscribe(
      {
        next: datos => {
          this.producto = datos;
        },
        error: err => {
  
        }
      });

     /* this.idTipo = (this.route.snapshot.paramMap.get('id') as string);     
     this.productoService.obtenerTipoId(this.idTipo).subscribe(
      {
        next: datos => {
          this.tipo = datos;
        },
        error: err => {
  
        }
      });*/

      }       

      Volver(){
        this.router.navigate(['/producto']);
      }
 }



