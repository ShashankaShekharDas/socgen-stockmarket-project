package com.shashanka.repositories;

import com.shashanka.entities.Company;
import com.shashanka.entities.CompanySector;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanySectorRepository extends CrudRepository<CompanySector,Integer> {
    public List<CompanySector> findAllByCompany(Company company);
}
