package com.shashanka.controller;

import com.shashanka.entities.StockExchange;
import com.shashanka.service.ExchangeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class ExchangeServiceController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    @ApiOperation(value = "Get Stock Exchanges",
                  notes = "Get all stock exchanges, returns an iterable",
                  response = Iterable.class)
    public Iterable<StockExchange> getStockExchange()
    {
        return this.exchangeService.getStockExchanges();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add Stock Exchanges",
                  notes = "Add stock exchanges, needs body in format of StockExchange entity",
                  response = ResponseEntity.class)
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
    @ApiOperation(value = "Get company in stock Exchanges",
                  notes = "Get company in a particular stock exchange, requires exchange id as parameter",
                  response = ResponseEntity.class)
    public ResponseEntity getCompanies(@PathVariable String exchangeId)
    {
        return exchangeService.getCompany(exchangeId).isPresent()?ResponseEntity.ok(exchangeService.getCompany(exchangeId).get()):ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Input");
    }

    @DeleteMapping("/{exchangeId}")
    @ApiOperation(value = "Delete an exchange",
                  notes = "Delete an exchange , pass the exchange id as parameter in the url",
                  response = ResponseEntity.class)
    public ResponseEntity deleteExchange(@PathVariable String exchangeId){
        return exchangeService.deleteExchange(exchangeId);
    }
}
