package com.shashanka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    private Company companyCode;

    @Column(length = 30)
    private String directorName;

    public Director(Company companyCode, String directorName) {
        this.companyCode = companyCode;
        this.directorName = directorName;
    }
}
