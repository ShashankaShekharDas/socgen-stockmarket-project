package com.shashanka.entities;


import javax.persistence.*;

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

    public StockExchange(){

    }

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
