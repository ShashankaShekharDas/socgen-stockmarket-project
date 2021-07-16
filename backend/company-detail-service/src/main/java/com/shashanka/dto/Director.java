package com.shashanka.dto;

import javax.persistence.*;

@Entity
@Table(name = "Director")
public class Director {
    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company CompanyName;

}
