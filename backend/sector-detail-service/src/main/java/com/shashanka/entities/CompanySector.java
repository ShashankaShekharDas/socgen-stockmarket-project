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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private Company companyName;

    @OneToOne
    @JoinColumn(referencedColumnName = "Id")
    private Sector sectorId;
}
