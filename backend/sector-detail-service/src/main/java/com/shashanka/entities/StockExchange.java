package com.shashanka.entities;


import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
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

    public StockExchange(String id, String name, String brief, String remarks) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
