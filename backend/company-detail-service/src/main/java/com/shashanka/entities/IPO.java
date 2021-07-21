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

    @Id
    private int id;

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

}
