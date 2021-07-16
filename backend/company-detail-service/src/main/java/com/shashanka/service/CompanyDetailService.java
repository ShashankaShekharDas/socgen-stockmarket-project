package com.shashanka.service;

import com.shashanka.dto.Company;
import com.shashanka.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyDetailService {
    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> getCompany(){
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyDetails(String companyName){
        return companyRepository.findById(companyName);
    }
}
