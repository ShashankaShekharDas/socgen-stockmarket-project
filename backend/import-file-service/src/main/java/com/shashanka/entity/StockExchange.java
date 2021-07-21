package com.shashanka.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STOCKEXCHANGE")
public class StockExchange {

    @Column(length = 5)
    @Id
    private String id;

    @Column(length = 20)
    private String name;

    @Column(length = 100)
    private String brief;

    @Column(length = 100)
    private String remarks;

}
