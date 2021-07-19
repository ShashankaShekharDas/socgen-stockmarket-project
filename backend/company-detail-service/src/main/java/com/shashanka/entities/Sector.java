package com.shashanka.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECTOR")
public class Sector {
    @Column(length = 5)
    @Id
    private String Id;

    @Column(length = 20)
    private String name;

    @Column(length = 100)
    private String about;

    public String getName() {
        return name;
    }

    public Sector(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public Sector(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
