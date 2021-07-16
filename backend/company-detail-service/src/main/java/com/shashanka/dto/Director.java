package com.shashanka.dto;

import javax.persistence.*;
import com.shashanka.dto.Company;

@Entity
@Table(name = "BoardOfDirector")
public class Director {
    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    @JoinColumn(name = "name")
    private Company CompanyName;

}
