package com.joyagold.service;

import com.joyagold.persistence.entity.Tipo;

import java.util.List;

public interface TipoServicio {

    List<Tipo> findAllTipos();

    Tipo findOneTipo(Long id);

}
