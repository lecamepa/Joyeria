import { Component,OnInit } from '@angular/core';
import { Producto } from 'src/app/model/producto';
import { Material } from 'src/app/model/material';
import { Tipo } from 'src/app/model/tipo';
import { ProductoService } from 'src/app/servicio/producto.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css']
})
export class NuevoComponent implements OnInit {

  materiales:Material[];
  tipos: Tipo[];
  newProducto : Producto = new Producto();

  constructor(private productoService:ProductoService,private router:Router){}

  ngOnInit(): void {
    this.newProducto.material="";
    this.productoService.getAllMateriales().subscribe(datos =>{
      next :{
        this.materiales=datos;
      }
      error:{
      }
    });

    this.newProducto.tipo="";
    this.productoService.getAllTipo().subscribe(datos =>{
      next :{
        this.tipos=datos;                
      }
      error:{
      }
    });

  }

  guardarEmpleado(){
  this.productoService.registrarProducto(this.newProducto).subscribe({
      next: respuesta =>{
        Swal.fire({
          title: "Guardar Producto",
          text: "Guardado Correctamente!",
          icon: "success"
        });
        this.router.navigate(['/producto']);
      },
      error: err  =>{
        console.log(err);
      }
        
    });
  }

  irListaProducto(){
    this.router.navigate(['/producto']);
  }

  onSubmit(){
    this.guardarEmpleado();
  }


}
