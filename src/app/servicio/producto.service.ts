import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../model/producto';
import { Material } from '../model/material';
import { Tipo } from '../model/tipo';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private baseURL = "http://localhost:9090"

  constructor(private httpClient:HttpClient) { }

  obtenerListaProducto():Observable<Producto[]>{
    return this.httpClient.get<Producto[]>(`${this.baseURL}/producto/lista`);
  }

  obtenerProducto(id:string):Observable<Producto>{
    return this.httpClient.get<Producto>(`${this.baseURL}/producto/buscar/${id}`);
  }
  registrarProducto(producto:Producto):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/producto/nuevo`,producto,{ headers: new HttpHeaders({      'Content-Type': 'application/json',}), responseType: 'text',});
  }

  actualizarProducto(id:string, producto:Producto): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/producto/editar/${id}`,producto,{ headers: new HttpHeaders({      'Content-Type': 'application/json',}), responseType: 'text',});

  }
  eliminarProducto(id:number){
    return this.httpClient.delete(`${this.baseURL}/producto/eliminar/${id}`,{ headers: new HttpHeaders({      'Content-Type': 'application/json',}), responseType: 'text',});
  }

  getAllMateriales():Observable<Material[]>{
    return this.httpClient.get<Material[]>(`${this.baseURL}/material/lista`);
  }
  getAllTipo():Observable<Tipo[]>{
    return this.httpClient.get<Tipo[]>(`${this.baseURL}/tipo/lista`);
  }

  obtenerTipoId(id:string):Observable<Tipo>{
    return this.httpClient.get<Tipo>(`${this.baseURL}/tipo/buscar/${id}`);
  }

  obtenerMaterialId(id:string):Observable<Material>{
    return this.httpClient.get<Material>(`${this.baseURL}/material/buscar/${id}`);
  }


 
}
