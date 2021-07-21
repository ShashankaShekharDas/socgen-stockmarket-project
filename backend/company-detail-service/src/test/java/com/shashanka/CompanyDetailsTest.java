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

        assertEquals(companyDetailService.getCompanyDetails("a1").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("aa1").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("aab").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("aax").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("b1").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("c1").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("d1").isPresent(),true);
        assertEquals(companyDetailService.getCompanyDetails("").isPresent(),false);
        assertEquals(companyDetailService.getCompanyDetails("dfgd").isPresent(),false);
        assertEquals(companyDetailService.getCompanyDetails("sdferg").isPresent(),false);
        assertEquals(companyDetailService.getCompanyDetails("etgbd").isPresent(),false);
        assertEquals(companyDetailService.getCompanyDetails("sfgd").isPresent(),false);

    }

    @Test
    public void getCompanyTests(){
        assertEquals(companyDetailService.getCompanyNames("a").size()==0,false);
        assertEquals(companyDetailService.getCompanyNames("a1").size()==0,false);
        assertEquals(companyDetailService.getCompanyNames("adfsgd").size()==0,true);
        assertEquals(companyDetailService.getCompanyNames("aa").size()==0,false);
        assertEquals(companyDetailService.getCompanyNames("b").size()==0,false);
        assertEquals(companyDetailService.getCompanyNames("").size()==0,false);
    }


}
