package com.shashanka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IPO")
public class IPO {

    @Column(length = 5)
    @Id
    private String id;

    @Column(columnDefinition="Decimal(6,2)")
    private double price;

    private int countShares;

    private LocalDateTime openingDateTime;

    @Column(length = 100)
    private String remarks;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private StockExchange ExchangeId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company companyName;

//    public IPO(String id, double price, int countShares, LocalDateTime openingDateTime, String remarks, StockExchange exchangeId, Company name) {
//        this.id = id;
//        this.price = price;
//        this.countShares = countShares;
//        this.openingDateTime = openingDateTime;
//        this.remarks = remarks;
//        ExchangeId = exchangeId;
//        this.name = name;
//    }
}
