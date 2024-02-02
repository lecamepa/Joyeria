import { Component,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Material } from 'src/app/model/material';
import { Producto } from 'src/app/model/producto';
import { Tipo } from 'src/app/model/tipo';
import { ProductoService } from 'src/app/servicio/producto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.css']
})
export class ActualizarComponent implements OnInit {
  
  id:string;
  materiales:Material[];
  tipos: Tipo[];
  editProducto : Producto = new Producto();

  
  constructor(private productoService:ProductoService,private router:Router,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.id=(this.route.snapshot.paramMap.get('id')as string);
    this.productoService.obtenerProducto(this.id).subscribe({
      next: datos => {
        this.editProducto=datos;
      },
      error: err => {

      }
    });
    
    this.productoService.getAllMateriales().subscribe(datos =>{
      next :{
        this.materiales=datos;
      }
      error:{
      }
    });

    
    this.productoService.getAllTipo().subscribe(datos =>{
      next :{
        this.tipos=datos;                
      }
      error:{
      }
    });

  }

  onSubmit(){
    this.productoService.actualizarProducto(this.id,this.editProducto).subscribe({
      next: respuesta => {
        Swal.fire({
          title: "Actualizar Producto",
          text: "Actualizado Correctamente!",
          icon: "success"
        });
        this.router.navigate(['/producto']);
      },
      error: err => {

      }
    });
  }
}
