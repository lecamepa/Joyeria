package com.joyagold.service.impl;

import com.joyagold.persistence.entity.Tipo;
import com.joyagold.persistence.repository.TipoRepository;
import com.joyagold.service.TipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServicioImpl implements TipoServicio {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<Tipo> findAllTipos() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo findOneTipo(Long id) {
        return tipoRepository.findById(id).orElse(null);
    }
}
