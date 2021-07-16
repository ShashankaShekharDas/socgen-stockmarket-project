package com.shashanka.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company {
    @Id
    private String name;

    private double turnover;

    private String ceo, about;

    boolean listed;

    public Company(){}

    public Company(String name, double turnover, String ceo, String about, boolean listed) {
        this.name = name;
        this.turnover = turnover;
        this.ceo = ceo;
        this.about = about;
        this.listed = listed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }
}
