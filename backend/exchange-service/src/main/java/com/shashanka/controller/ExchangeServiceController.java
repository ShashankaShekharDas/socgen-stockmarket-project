package com.shashanka.controller;

import com.shashanka.entities.StockExchange;
import com.shashanka.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/exchange")
@RestController
public class ExchangeServiceController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public Iterable<StockExchange> getStockExchange()
    {
        return this.exchangeService.getStockExchanges();
    }

    @PostMapping("/add")
    public ResponseEntity addStockExchange(@RequestBody StockExchange stockExchange)
    {
        try {
            exchangeService.addStockExchange(stockExchange);
            return ResponseEntity.ok("Exchange Added Successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Input");
        }

    }
    @GetMapping("/getCompanies/{exchangeId}")
    public ResponseEntity getCompanies(@PathVariable String exchangeId)
    {
        return exchangeService.getCompany(exchangeId).isPresent()?ResponseEntity.ok(exchangeService.getCompany(exchangeId).get()):ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Input");
    }
}
