package com.shashanka.dao;

import com.shashanka.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository  extends CrudRepository<Company,String> {
}


