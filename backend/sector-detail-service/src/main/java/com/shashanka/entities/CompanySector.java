package com.shashanka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COMPANYSECTOR")
public class CompanySector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    private Company company;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Id")
    private Sector sectorId;
}
