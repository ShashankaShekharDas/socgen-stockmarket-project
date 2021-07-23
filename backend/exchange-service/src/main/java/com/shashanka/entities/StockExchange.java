package com.shashanka.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STOCKEXCHANGE")
@NamedQuery(name = "find_all_persons",query = "select exchange from StockExchange exchange")
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
