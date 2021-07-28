package com.shashanka.repositories;

import com.shashanka.entities.Company;
import com.shashanka.entities.Director;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DirectorRepository extends CrudRepository<Director,Integer> {
    public List<Director> findAllByCompanyCode(Company company);
}
