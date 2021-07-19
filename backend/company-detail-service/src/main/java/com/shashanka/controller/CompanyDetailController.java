package com.shashanka.controller;

import com.shashanka.entities.Company;
import com.shashanka.entities.Stock;
import com.shashanka.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class CompanyDetailController {

    @Autowired
    CompanyDetailService companyDetailService;

    @GetMapping("/getAllCompanies")
    public Iterable<Company> getAllCompanies(){
        return companyDetailService.getCompany();
    }

    @GetMapping("/company/data/{companyName}")
    public Company getCompanyData(@PathVariable String companyName){
        return companyDetailService.getCompanyDetails(companyName).isPresent()?companyDetailService.getCompanyDetails(companyName).get():null;
    }

    @GetMapping("/viewCompany/charts/{companyId}/{exchangeID}/{periodFrom}/{periodTo}/{periodicity}")
    public List<Stock> retrievePeriodData(@PathVariable String companyId,@PathVariable String exchangeID, @PathVariable String periodFrom, @PathVariable String  periodTo, @PathVariable int periodicity)
    {
        return companyDetailService.retrievePeriodData(companyId,exchangeID,periodFrom,periodTo,periodicity);
    }

    @GetMapping("/viewCompany/{pattern}")
    public List<Company> getCompanyNames(@PathVariable String pattern){
        return companyDetailService.getCompanyNames(pattern);
    }
}
