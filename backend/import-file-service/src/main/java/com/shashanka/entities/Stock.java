package com.shashanka.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int companyCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private StockExchange exchangeId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company companyName;

    @Column(precision = 8,scale = 2)
    private double price;

    private LocalDateTime dateTime;

    public Stock(int companyCode, com.shashanka.entities.StockExchange exchangeId, com.shashanka.entities.Company companyName, double price, LocalDateTime dateTime) {
        this.companyCode = companyCode;
        this.exchangeId = exchangeId;
        this.companyName = companyName;
        this.price = price;
        this.dateTime = dateTime;
    }
}
