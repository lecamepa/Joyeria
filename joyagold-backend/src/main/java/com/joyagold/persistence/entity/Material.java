package com.joyagold.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MATERIAL")
public class Material {

    @Id
    @Column(name = "MATE_ID")
    private Long id;

    @Column(name = "MATE_NOMBRE")
    private String nombre;



}
