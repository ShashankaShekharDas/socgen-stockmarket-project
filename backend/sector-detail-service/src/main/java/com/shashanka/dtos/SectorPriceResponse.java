package com.shashanka.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SectorPriceResponse {
    private String error;
    private List<StockDTO> listStock;
}
