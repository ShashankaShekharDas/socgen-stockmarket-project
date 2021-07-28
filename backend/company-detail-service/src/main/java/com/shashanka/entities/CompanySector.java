package com.shashanka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Table(name = "COMPANYSECTOR")
public class CompanySector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    private Company company;

    @OneToOne
    @JoinColumn(referencedColumnName = "Id")
    private Sector sectorId;

    public CompanySector(Company company, Sector sectorId) {
        this.company = company;
        this.sectorId = sectorId;
    }
}
