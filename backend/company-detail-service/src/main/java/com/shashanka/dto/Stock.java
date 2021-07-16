package com.shashanka.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private StockExchange ExchangeId;

    private double price;

    private LocalDateTime dateTime;

    public Stock(){}

    public Stock(String companyCode, StockExchange exchangeId, double price, LocalDateTime dateTime) {
        this.companyCode = companyCode;
        ExchangeId = exchangeId;
        this.price = price;
        this.dateTime = dateTime;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public StockExchange getExchangeId() {
        return ExchangeId;
    }

    public void setExchangeId(StockExchange exchangeId) {
        ExchangeId = exchangeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
