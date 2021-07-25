package com.shashanka.controller;

import com.shashanka.entities.StockExchange;
import com.shashanka.service.ExchangeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/exchange")
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
    @GetMapping("{exchangeId}")
    @ApiOperation(value = "Get stock Exchange detail",
                  notes = "Get details of a particular stock exchange, pass exchange id as parameter",
                  response = ResponseEntity.class)
    public ResponseEntity getExchange(@PathVariable String exchangeId)
    {
        return exchangeService.getExchange(exchangeId).isPresent()?ResponseEntity.ok(exchangeService.getExchange(exchangeId).get()):ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Input");
    }

    @DeleteMapping("/{exchangeId}")
    @ApiOperation(value = "Delete an exchange",
                  notes = "Delete an exchange , pass the exchange id as parameter in the url",
                  response = ResponseEntity.class)
    public ResponseEntity deleteExchange(@PathVariable String exchangeId){
        return exchangeService.deleteExchange(exchangeId);
    }

    @GetMapping("getCompany/{exchangeId}")
    @ApiOperation(value = "All stock of an exchange",
                  notes = "Gets all stock present in an exchange",
                  response = ResponseEntity.class)
    public ResponseEntity getStock(@PathVariable String exchangeId)
    {
        return exchangeService.getStock(exchangeId);
    }
}
