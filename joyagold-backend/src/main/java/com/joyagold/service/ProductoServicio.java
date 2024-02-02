package com.joyagold.service;

import com.joyagold.dto.ProductoDto;
import com.joyagold.persistence.entity.Producto;

import java.util.List;

public interface ProductoServicio {

    List<ProductoDto> findAllProductos();

    ProductoDto findOneProductoDto(Long id);

    Producto findOneProducto(Long id);

    Producto saveProducto(ProductoDto producto);

    Producto editProducto(Long id,ProductoDto productoDto);

    boolean deleteProducto(Long id);

}
