package com.shashanka.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCKEXCHANGE")
public class StockExchange {

    @Id
    private String id;
    private String name,brief,remarks;

    public StockExchange(){}

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

    public void setName(String name) {
        this.name = name;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public String getBrief() {
        return brief;
    }

    public String getRemarks() {
        return remarks;
    }
}
