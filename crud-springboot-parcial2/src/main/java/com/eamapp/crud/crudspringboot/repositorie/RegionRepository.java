package com.eamapp.crud.crudspringboot.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eamapp.crud.crudspringboot.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
}
