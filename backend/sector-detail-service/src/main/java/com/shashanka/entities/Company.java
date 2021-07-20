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
@Table(name="COMPANY")
public class Company {

    @Column(length = 30)
    @Id
    private String name;

    @Column(precision = 15,scale = 2)
    private double turnover;

    @Column(length = 30)
    private String ceo;

    @Column(length = 200)
    private String about;

    boolean listed;


}
