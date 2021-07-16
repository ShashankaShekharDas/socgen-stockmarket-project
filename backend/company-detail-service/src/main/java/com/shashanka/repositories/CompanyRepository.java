package com.shashanka.repositories;

import com.shashanka.dto.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository  extends CrudRepository<Company,String> {
}


