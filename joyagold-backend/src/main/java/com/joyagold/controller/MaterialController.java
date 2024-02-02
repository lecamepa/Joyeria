package com.joyagold.controller;


import com.joyagold.persistence.entity.Material;
import com.joyagold.service.MaterialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialServicio materialServicio;

    @GetMapping("/lista")
    public List<Material> findAllMaterials(){
        return materialServicio.findAllMaterials();
    }

    @GetMapping("/buscar/{id}")
    public Material findOneMaterial(@PathVariable Long id){
        return materialServicio.findOneMaterial(id);
    }


}
