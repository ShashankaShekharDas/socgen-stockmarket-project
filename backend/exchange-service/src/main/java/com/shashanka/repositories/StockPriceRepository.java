package com.shashanka.repositories;

import com.shashanka.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<Stock, Integer> {
}
