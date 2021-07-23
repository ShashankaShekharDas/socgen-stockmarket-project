package com.shashanka.service;

import com.shashanka.entities.StockExchange;
import com.shashanka.repository.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private StockExchangeRepository stockExchangeRepository;

    private final RestTemplate restTemplate;
    public ExchangeService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Iterable<StockExchange> getStockExchanges() {
        return stockExchangeRepository.findAll();
    }

    public StockExchange addStockExchange(StockExchange stockExchange) {
        StockExchange save = stockExchangeRepository.save(stockExchange);
        return save;
    }

    public Optional<StockExchange> getCompany(String id)
    {
        return stockExchangeRepository.findById(id);
    }

    public ResponseEntity deleteExchange(String id)
    {
        try {
            stockExchangeRepository.deleteById(id);
            return ResponseEntity.ok("Exchange Deleted Succesfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt delete exchange");
        }
    }
}
