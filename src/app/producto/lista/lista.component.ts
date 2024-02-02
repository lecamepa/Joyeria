import { Component,OnInit } from '@angular/core';
import { Producto } from 'src/app/model/producto';
import { ProductoService } from 'src/app/servicio/producto.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit{
   producto: Producto[]; 
   

   constructor(private productoServicio:ProductoService,private router:Router){}

   ngOnInit(): void {
    this.obtenerProductos();
   }

   actualizarProducto(id:number){    
    this.router.navigate(['actualizar',id]);
   }

   eliminarProducto(id:number){ 

    Swal.fire({
      icon: 'warning',
      title: 'Eliminar Producto',
      text: '¿Desea eliminar el producto?',
      showCancelButton: true,
      confirmButtonText: 'Confirmar',
      cancelButtonText: 'Cancelar',
      confirmButtonColor: "green",
    }).then( (result) =>{
      if(result.isConfirmed){
        this.productoServicio.eliminarProducto(id).subscribe({
          next: respuesta =>{
            console.log(respuesta);
            this.obtenerProductos();
            if(respuesta==="OK"){
              Swal.fire({
                icon: 'success',
                title: 'Eliminar Producto',
                text: 'Producto eliminado',
                confirmButtonText: 'Continuar',
                confirmButtonColor: "green"
              });
              
            }
          },
          error: err  =>{
            Swal.fire({
              icon: 'error',
              title: 'Eliminar Producto',
              text: 'Error al eliminar',
              confirmButtonText: 'Continuar',
              confirmButtonColor: "green"
            });
          }
        });
      }
    });
    

    
   }
   private obtenerProductos(){
    this.productoServicio.obtenerListaProducto().subscribe(
      dato =>{this.producto = dato;
      });
   }

   verDetalles(id:number){
    this.router.navigate(['detalle',id]);
   }
       
   
}
