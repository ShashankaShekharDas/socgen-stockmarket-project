package com.shashanka.contoller;

import com.shashanka.dto.StockExchange;
import com.shashanka.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class ExchangeServiceController {
    private ExchangeService exchangeService;

    /*
        TODO
        * Add Checks for the size of allowed inputs
     */


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
    public StockExchange addStockExchange(@RequestBody StockExchange stockExchange)
    {
        return exchangeService.addStockExchange(stockExchange);
    }

    @GetMapping("/getCompanies/{exchangeId}")
    public Optional<StockExchange> getCompanies(@PathVariable String exchangeId)
    {
        return exchangeService.getCompany(exchangeId);
    }
}
