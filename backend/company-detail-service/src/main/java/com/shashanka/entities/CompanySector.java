package com.shashanka.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "COMPANYSECTOR")
public class CompanySector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    private Company company;

    @OneToOne
    @JoinColumn(referencedColumnName = "Id")
    private Sector sectorId;
}
