package com.joyagold.service;

import com.joyagold.persistence.entity.Material;

import java.util.List;

public interface MaterialServicio {

    List<Material> findAllMaterials();

    Material findOneMaterial(Long id);
}
