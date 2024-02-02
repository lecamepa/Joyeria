package com.joyagold.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @SequenceGenerator(name = "S_PROD_ID", sequenceName = "S_PROD_ID", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "S_PROD_ID")
    @Column(name = "PROD_ID")
    private Long id;

    @Column(name = "PROD_NOMBRE")
    private String nombre;

    @Column(name = "PROD_PRECIO")
    private BigDecimal precio;

    @Column(name = "PROD_PESO")
    private BigDecimal peso;

    @Column(name = "PROD_FECHACAMBIO")
    private Date fechaCambio;

    @ManyToOne
    @JoinColumn(name = "MATE_ID")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "TIPO_ID")
    private Tipo tipo;
}
