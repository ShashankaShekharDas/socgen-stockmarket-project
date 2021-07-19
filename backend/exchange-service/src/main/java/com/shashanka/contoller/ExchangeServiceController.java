package com.shashanka.contoller;

import com.shashanka.dtos.Response;
import com.shashanka.entities.StockExchange;
import com.shashanka.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class ExchangeServiceController {
    private ExchangeService exchangeService;

    @Autowired
    public ExchangeServiceController(ExchangeService exchangeService)
    {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/manageStockExchanges")
    public Iterable<StockExchange> getStockExchange()
    {
        return this.exchangeService.getStockExchanges();
    }

    @PostMapping("/manageStockExchanges")
    public ResponseEntity<Response> addStockExchange(@RequestBody StockExchange stockExchange)
    {
        Response response = new Response();
        try {
            exchangeService.addStockExchange(stockExchange);
            response.setStatus(true);
            response.setMessage("Exchange Added Sucessfully");
            return ResponseEntity.ok(response);
        }
        catch (Exception e)
        {
            response.setStatus(false);
            response.setError("Invalid Input");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getCompanies/{exchangeId}")
    public StockExchange getCompanies(@PathVariable String exchangeId)
    {
        return exchangeService.getCompany(exchangeId).isPresent()?exchangeService.getCompany(exchangeId).get():null;
    }
}
