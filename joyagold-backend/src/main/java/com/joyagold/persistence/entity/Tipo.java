package com.joyagold.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TIPO")
public class Tipo {

    @Id
    @Column(name = "TIPO_ID")
    private Long id;

    @Column(name = "TIPO_NOMBRE")
    private String nombre;

}
