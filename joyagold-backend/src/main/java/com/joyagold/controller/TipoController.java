package com.joyagold.controller;

import com.joyagold.persistence.entity.Material;
import com.joyagold.persistence.entity.Tipo;
import com.joyagold.service.TipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TipoServicio tipoServicio;


    @GetMapping("/lista")
    public List<Tipo> findAllTipos(){ return tipoServicio.findAllTipos();
    }

    @GetMapping("/buscar/{id}")
    public Tipo findOneTipo(@PathVariable Long id){
        return tipoServicio.findOneTipo(id);
    }
}
