package com.joyagold.service.impl;

import com.joyagold.persistence.entity.Material;
import com.joyagold.persistence.repository.MaterialRepository;
import com.joyagold.service.MaterialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServicioImpl implements MaterialServicio {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public Material findOneMaterial(Long id) {
        return materialRepository.findById(id).orElse(null);
    }
}
