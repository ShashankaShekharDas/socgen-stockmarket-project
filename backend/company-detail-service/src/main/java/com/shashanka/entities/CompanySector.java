package com.shashanka.entities;

import javax.persistence.*;

@Entity
@Table(name = "COMPANYSECTOR")
public class CompanySector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company companyName;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Id")
    private Sector sectorId;

    public CompanySector(){}

//    public CompanySector(Company companyName, Sector sectorId) {
//        this.companyName = companyName;
//        this.sectorId = sectorId;
//    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

//    public Sector getSectorId() {
//        return sectorId;
//    }
//
//    public void setSectorId(Sector sectorId) {
//        this.sectorId = sectorId;
//    }
}
