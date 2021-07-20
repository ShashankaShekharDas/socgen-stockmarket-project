package com.shashanka.dtos;

import com.shashanka.entities.Sector;
import lombok.Data;

import java.util.List;

@Data
public class CompanyResponse {
    private String error;
    private List<Sector> company;
}
