package com.shashanka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer companyCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private StockExchange exchangeId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company companyName;

    @Column(precision = 8,scale = 2)
    private double price;

    private LocalDateTime dateTime;

    public Stock(Integer companyCode, StockExchange exchangeId, Company companyName, double price, LocalDateTime dateTime) {
        this.companyCode = companyCode;
        this.exchangeId = exchangeId;
        this.companyName = companyName;
        this.price = price;
        this.dateTime = dateTime;
    }
}
