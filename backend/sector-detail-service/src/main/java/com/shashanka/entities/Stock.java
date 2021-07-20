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

    @Column(length = 5)
    private String companyCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private StockExchange exchangeId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company companyName;

    @Column(precision = 8,scale = 2)
    private double price;

    private LocalDateTime dateTime;

    public Stock(String companyCode, StockExchange exchangeId, double price, LocalDateTime dateTime) {
        this.companyCode = companyCode;
        this.exchangeId = exchangeId;
        this.price = price;
        this.dateTime = dateTime;
    }
}
