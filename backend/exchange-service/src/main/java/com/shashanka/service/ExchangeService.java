package com.shashanka.service;

import com.shashanka.entities.StockExchange;
import com.shashanka.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
@Service
public class ExchangeService {

    @Autowired
    private StockRepository stockRepository;

    private final RestTemplate restTemplate;
    public ExchangeService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Iterable<StockExchange> getStockExchanges() {
        return stockRepository.findAll();
    }

    public StockExchange addStockExchange(StockExchange stockExchange) {
        StockExchange save = stockRepository.save(stockExchange);
        return save;
    }

    public Optional<StockExchange> getCompany(String id)
    {
        return stockRepository.findById(id);
    }

}