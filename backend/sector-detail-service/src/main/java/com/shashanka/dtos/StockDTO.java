package com.shashanka.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private String company_name_name;
    private String exchange_id_id;
    private String company_code;
    private double price;
}
