package com.joyagold.controller;

import com.joyagold.dto.ProductoDto;
import com.joyagold.persistence.entity.Producto;
import com.joyagold.service.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/lista")
    public List<ProductoDto> findAllProductos(){
        return productoServicio.findAllProductos();
    }

    @GetMapping("/buscar/{id}")
    public ProductoDto findOneProducto(@PathVariable Long id){
        return productoServicio.findOneProductoDto(id);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> saveProducto(@RequestBody ProductoDto productoDto){
        if(productoServicio.saveProducto(productoDto)==null)
            return ResponseEntity.ok("ERROR");
        return ResponseEntity.ok("OK");
    }

    @PutMapping("/editar/{id}")
    public String editProducto(@PathVariable Long id,@RequestBody ProductoDto productoDto){
        if(productoServicio.editProducto(id,productoDto)==null)
            return "ERROR";
        return "OK";
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Long id){
        if(!productoServicio.deleteProducto(id))
            return ResponseEntity.ok("ERROR");
        return ResponseEntity.ok("OK");
    }


}
