package com.shashanka.entities;

import javax.persistence.*;

@Entity
@Table(name = "Director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company CompanyName;

    @Column(length = 30)
    private String DirectorName;

}
