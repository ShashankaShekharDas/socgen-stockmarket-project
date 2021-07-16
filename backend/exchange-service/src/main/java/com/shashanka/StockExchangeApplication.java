package com.shashanka;

import com.shashanka.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockExchangeApplication{

	@Autowired
	private ExchangeService exchangeService;

	public static void main(String[] args) {
		SpringApplication.run(StockExchangeApplication.class, args);
	}
}
