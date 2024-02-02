package com.joyagold.service.impl;

import com.joyagold.dto.ProductoDto;
import com.joyagold.persistence.entity.Material;
import com.joyagold.persistence.entity.Producto;
import com.joyagold.persistence.entity.Tipo;
import com.joyagold.persistence.repository.ProductoRepository;
import com.joyagold.service.MaterialServicio;
import com.joyagold.service.ProductoServicio;
import com.joyagold.service.TipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MaterialServicio materialServicio;

    @Autowired
    private TipoServicio tipoServicio;
    @Override
    public List<ProductoDto> findAllProductos() {
        List<ProductoDto> productoDtos=new ArrayList<>();
        List<Producto> productos = productoRepository.findAll();
        for(Producto producto : productos){
            productoDtos.add(productoToDto(producto));
        }
        return productoDtos;
    }

    @Override
    public Producto findOneProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto saveProducto(ProductoDto productoDto) {
        productoDto.setFechaCambio(new Date());
        return productoRepository.save(dtoProducto(productoDto));
    }


    @Override
    public ProductoDto findOneProductoDto(Long id) {
        Producto producto= productoRepository.findById(id).orElse(null);
        if(producto!=null)
            return productoToDto(producto);
        return null;
    }

    @Override
    public Producto editProducto(Long id, ProductoDto productoDto) {
        Producto oldProducto = this.findOneProducto(id);
        oldProducto.setNombre(productoDto.getNombre());
        Tipo tipo=tipoServicio.findOneTipo(productoDto.getTipo());
        Material material=materialServicio.findOneMaterial(productoDto.getMaterial());
        oldProducto.setMaterial(material);
        oldProducto.setTipo(tipo);
        oldProducto.setPrecio(productoDto.getPrecio());
        oldProducto.setPeso(productoDto.getPeso());
        oldProducto.setFechaCambio(new Date());
        if(oldProducto!=null)
            return productoRepository.save(oldProducto);
        return null;
    }

    @Override
    public boolean deleteProducto(Long id) {
        try {
            Producto producto = this.findOneProducto(id);
            productoRepository.delete(producto);
        }catch (Exception ex){
            return false;
        }
        return  true;
    }

    private Producto dtoProducto(ProductoDto productoDto){
        Producto producto=new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setPeso(productoDto.getPeso());
        producto.setFechaCambio(productoDto.getFechaCambio());
        Tipo tipo =tipoServicio.findOneTipo(productoDto.getTipo());
        Material material=materialServicio.findOneMaterial(productoDto.getMaterial());
        producto.setTipo(tipo);
        producto.setMaterial(material);
        return  producto;
    }
    private ProductoDto productoToDto (Producto producto){
        ProductoDto  productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setNombre(producto.getNombre());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setPeso(producto.getPeso());
        productoDto.setFechaCambio(producto.getFechaCambio());
        productoDto.setTipo(producto.getTipo().getId());
        productoDto.setNombreTipo(producto.getTipo().getNombre());
        productoDto.setMaterial(producto.getMaterial().getId());
        productoDto.setNombreMaterial(producto.getMaterial().getNombre());

        return productoDto;
    }
}
