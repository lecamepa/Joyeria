package com.joyagold.dto;

import com.joyagold.persistence.entity.Material;
import com.joyagold.persistence.entity.Tipo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class ProductoDto {
    private Long id;

    private String nombre;

    private BigDecimal precio;

    private BigDecimal peso;

    private Date fechaCambio;

    private Long material;

    private Long tipo;

    private String nombreTipo;

    private String nombreMaterial;
}
