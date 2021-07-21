package com.shashanka;

import com.shashanka.controller.IPOController;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.IPORepository;
import com.shashanka.repositories.StockExchangeRepository;
import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.service.CompanyDetailService;
import com.shashanka.service.IPOService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPOServicesTest {

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

    @Before
    public void init(){
    }

    public void addIPOTests(){
    }

    public void getIPOTests(){

    }


}
