package com.shashanka.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECTOR")
public class Sector {
    @Id
    private String Id;

    private String name,about;

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
