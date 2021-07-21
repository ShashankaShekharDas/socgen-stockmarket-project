package com.shashanka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sector")
public class Sector {

    @Id
    @Column(length = 5)
    private String id;

    @Column(length = 20)
    private String name;

    @Column(length = 100)
    private String about;

}
