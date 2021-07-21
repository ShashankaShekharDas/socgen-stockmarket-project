package com.shashanka;

import com.shashanka.controller.IPOController;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.IPORepository;
import com.shashanka.repositories.StockExchangeRepository;
import com.shashanka.service.CompanyDetailService;
import com.shashanka.service.IPOService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDetailsTest {

    @Autowired
    private IPOController ipoController;

    @Autowired
    private IPOService ipoService;

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IPORepository ipoRepository;

    @Autowired
    CompanyDetailService companyDetailService;

    @Test
    public void getCompanyDetailsTests(){

//        Write new tests

    }

    @Test
    public void getCompanyTests(){
//        Write new tests
    }


}