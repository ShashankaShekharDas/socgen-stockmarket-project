package com.shashanka;

import com.shashanka.controller.IPOController;
import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.service.IPOService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@SpringBootTest
class CompanyDetailServiceApplicationTests {

	@Mock
	IPOService ipoService;

	@InjectMocks
	IPOController ipoController;

	@Test
	void contextLoads() {
	}

	@Test
	void addIPOtests(){
		//test invalid inputs and correct inputs

		IPOResponse ipoResponseCorrect = new IPOResponse();
		IPOResponse ipoResponseWrong = new IPOResponse();

		ipoResponseCorrect.setStatus(true);
		ipoResponseWrong.setMessage("IPO Added Successfully");
		ResponseEntity<IPOResponse> correct = ResponseEntity.ok(ipoResponseCorrect);

		ipoResponseWrong.setStatus(false);
		ipoResponseWrong.setError("Invalid Input");
		ResponseEntity<IPOResponse> wrong = new ResponseEntity<IPOResponse>(ipoResponseWrong, HttpStatus.BAD_REQUEST);

		IPO ipoTest1 = new IPO("test1",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSE","A1");
		IPO ipoTest2 = new IPO("test2",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSE","A1sdf");
		IPO ipoTest3 = new IPO("test3",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSEB","A1sdf");
		IPO ipoTest4 = new IPO("test4",(double) 123.45,12, LocalDateTime.parse("2019-01-01T05:05:05"),"ok","NSEBsdfsfg","A1");

	}
}
