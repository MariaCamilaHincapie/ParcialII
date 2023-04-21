package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eamapp.crud.crudspringboot.entity.Comercial;
import com.eamapp.crud.crudspringboot.repositorie.ComercialRepository;

@Service
public class ComercialServiceImpl implements ComercialService {

    @Autowired
    private ComercialRepository repository;

    @Override
    public List<Comercial> allComercials() {
        return repository.findAll();
    }

    @Override
    public Comercial saveComercial(Comercial comercial) {
        return repository.save(comercial);
    }

    @Override
    public Comercial getComercialById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Comercial updateComercial(Comercial comercial) {
        return repository.save(comercial);
    }

    @Override
    public void deleteComercial(Long id) {
        repository.deleteById(id);
    };
}
