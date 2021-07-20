package com.shashanka;

import com.shashanka.controller.IPOController;
import com.shashanka.dao.CompanyRepository;
import com.shashanka.dao.IPORepository;
import com.shashanka.dao.StockExchangeRepository;
import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.service.CompanyDetailService;
import com.shashanka.service.IPOService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @Test
    public void addIPOTests(){
        //test invalid inputs and correct inputs

        IPOResponse ipoResponseCorrect = new IPOResponse();
        IPOResponse ipoResponseWrong = new IPOResponse();

        ipoResponseCorrect.setStatus(true);
        ipoResponseCorrect.setMessage("IPO Added Successfully");
        ResponseEntity<IPOResponse> correct = ResponseEntity.ok(ipoResponseCorrect);

        ipoResponseWrong.setStatus(false);
        ipoResponseWrong.setError("Invalid Input");
        ResponseEntity<IPOResponse> wrong = new ResponseEntity<IPOResponse>(ipoResponseWrong, HttpStatus.BAD_REQUEST);

        IPO ipoTest1 = new IPO("test1",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSE","A1");
        IPO ipoTest2 = new IPO("test2",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSE","A1sdf");
        IPO ipoTest3 = new IPO("test3",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSEB","A1sdf");
        IPO ipoTest4 = new IPO("test4",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSEBsdfsfg","A1");
        IPO ipoTest5 = new IPO("test5",(double) 1234.45,100, LocalDateTime.parse("2021-01-01T05:05:05"),"ok","BSE","AA1");

        assertEquals(ipoController.addIPO(ipoTest1),correct);
        assertEquals(ipoController.addIPO(ipoTest2),wrong);
        assertEquals(ipoController.addIPO(ipoTest3),wrong);
        assertEquals(ipoController.addIPO(ipoTest4),wrong);
        assertEquals(ipoController.addIPO(ipoTest5),correct);
    }

    @Test
    public void getIPOTests(){
        String test = "adfsg";
        String test2 = "";
        String test3 = "AB";
        String test4 = "AB_";
        String test5 = "fsdgbgd";
        String test6 = "db";

        ResponseEntity<String> incorrect = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such IPO");

        assertEquals(ipoService.getIPO(test).isPresent(),false);
        assertEquals(ipoService.getIPO(test2).isPresent(),false);
        assertEquals(ipoService.getIPO(test3).isPresent(),true);
        assertEquals(ipoService.getIPO(test4).isPresent(),false);
        assertEquals(ipoService.getIPO(test5).isPresent(),false);
        assertEquals(ipoService.getIPO(test6).isPresent(),true);

    }


}
