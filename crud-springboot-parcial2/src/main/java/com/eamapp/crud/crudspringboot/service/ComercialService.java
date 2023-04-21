package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import com.eamapp.crud.crudspringboot.entity.Comercial;

public interface ComercialService {
    public List<Comercial> allComercials();

    public Comercial saveComercial(Comercial comercial);

    public Comercial getComercialById(Long id);

    public Comercial updateComercial(Comercial comercial);

    public void deleteComercial(Long id);
}