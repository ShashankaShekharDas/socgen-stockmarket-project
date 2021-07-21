package com.shashanka.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPO {
    private String id;

    private double price;

    private int countShares;

    private LocalDateTime openingDateTime;

    private String remarks;

    private String exchangeId;

    private String companyName;

}
