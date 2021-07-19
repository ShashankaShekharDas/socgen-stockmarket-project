package com.shashanka.service;

import com.shashanka.entities.Stock;
import com.shashanka.entities.StockExchange;
import com.shashanka.repositories.StockExchangeRepository;
import com.shashanka.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class FakerService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private StockRepository stockRepository;

    public boolean addStock(String companyCode,String exchangeId){
//        Faker library so assuming exchange exists
        StockExchange stockExchange = stockExchangeRepository.findById(exchangeId).get();
        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0;i < 1000;i++) {
            localDateTime = localDateTime.plusMinutes(5);
            stockRepository.save(new Stock(companyCode, stockExchange, 100 * (new Random().nextDouble()), localDateTime));
        }
        return true;
    }
}
