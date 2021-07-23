package com.shashanka.repositories;

import com.shashanka.entities.CompanySector;
import com.shashanka.entities.Sector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanySectorRepository extends CrudRepository<CompanySector,Integer> {
    public List<CompanySector> findAllBySectorId(Sector sector);
}
