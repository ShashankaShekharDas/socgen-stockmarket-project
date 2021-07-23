package com.shashanka.repositories;

import com.shashanka.entities.Company;
import com.shashanka.entities.IPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpoJPA extends JpaRepository<IPO,Integer> {
    public IPO findByCompanyId(Company companyId);
}
