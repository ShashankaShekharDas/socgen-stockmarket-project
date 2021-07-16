package com.shashanka.controller;

import com.shashanka.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class CompanyDetailController {

    /*
        TODO
        Microservice to retrieve data of a company, for certain period, getCompanyStockPrice i/p Company ID, From Period, To Period, periodicity )
        ( /user/viewCompany/charts/{companyId}/{period}/{periodicity} )
        getMatchingCompanies – used to retrieve list of Companies based on pattern matching of Company Name
        ( /user/viewCompany/{pattern} )
        getCompanyDetails – Basic information about company
        ( /user/viewCompany/data/{companyId} )
        getCompanyIPODetails – IPODetails of Company
        ( /user/viewIPO/{companyId} )
     */

    @Autowired
    CompanyDetailService companyDetailService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getAllCompanies")
    public String getAllCompanies(){
        return companyDetailService.getCompany();
    }


}
