package com.shashanka.controller;

import com.shashanka.dto.Company;
import com.shashanka.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/user")
@RestController
public class CompanyDetailController {

    /*
        TODO
        Microservice to retrieve data of a company, for certain period, getCompanyStockPrice i/p Company ID, From Period, To Period, periodicity )
        ( /user/viewCompany/charts/{companyId}/{period}/{periodicity} )

        Periodicity Options : 5 min to 1 hr
        Period : 
        getMatchingCompanies – used to retrieve list of Companies based on pattern matching of Company Name
        ( /user/viewCompany/{pattern} )
        getCompanyIPODetails – IPODetails of Company : Depends on IPO Implementation
        ( /user/viewIPO/{companyId} )
     */

    @Autowired
    CompanyDetailService companyDetailService;

    @GetMapping("/getAllCompanies")
    public Iterable<Company> getAllCompanies(){
        return companyDetailService.getCompany();
    }

    @GetMapping("/company/data/{companyName}")
    public Optional<Company> getCompanyData(@PathVariable String companyName){
        return companyDetailService.getCompanyDetails(companyName);
    }
}
