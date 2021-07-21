package com.shashanka.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "SECTOR")
public class Sector {
    @Column(length = 5)
    @Id
    private String Id;

    @Column(length = 20)
    private String name;

    @Column(length = 100)
    private String about;

    public Sector(String name, String about) {
        this.name = name;
        this.about = about;
    }

}
