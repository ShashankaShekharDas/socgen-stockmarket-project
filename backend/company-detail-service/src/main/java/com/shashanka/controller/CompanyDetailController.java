package com.shashanka.controller;

import com.shashanka.entities.Company;
import com.shashanka.entities.Stock;
import com.shashanka.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyDetailController {

    @Autowired
    CompanyDetailService companyDetailService;

    @GetMapping("/all")
    public Iterable<Company> getAllCompanies(){
        return companyDetailService.getCompany();
    }

    @GetMapping("/specific/{companyName}")
    public ResponseEntity getCompanyData(@PathVariable String companyName){
        return companyDetailService.getCompanyDetails(companyName).size()>0?ResponseEntity.ok(companyDetailService.getCompanyDetails(companyName).get(0)):ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Company with name "+companyName+" not found");
    }

    @GetMapping("/{companyId}/{exchangeID}/{periodFrom}/{periodTo}/{periodicity}")
    public ResponseEntity retrievePeriodData(@PathVariable String companyId,@PathVariable String exchangeID, @PathVariable String periodFrom, @PathVariable String  periodTo, @PathVariable int periodicity)
    {
        List<Stock> stocks = companyDetailService.retrievePeriodData(companyId, exchangeID, periodFrom, periodTo, periodicity);
        return stocks.size() == 0? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No stocks found with given parameters"):ResponseEntity.ok(stocks);
    }

    @GetMapping("/viewPattern/{pattern}")
    public ResponseEntity getCompanyNames(@PathVariable String pattern){
        List<Company> companyNames = companyDetailService.getCompanyNames(pattern);
        return ResponseEntity.ok(companyNames);
    }
}
