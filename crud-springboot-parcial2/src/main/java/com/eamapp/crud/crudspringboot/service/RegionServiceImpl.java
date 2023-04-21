package com.eamapp.crud.crudspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eamapp.crud.crudspringboot.entity.Region;
import com.eamapp.crud.crudspringboot.repositorie.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository repository;

    @Override
    public List<Region> allRegions() {
        return repository.findAll();
    }
}
