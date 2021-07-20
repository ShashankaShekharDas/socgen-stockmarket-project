package com.shashanka.dao;

import com.shashanka.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock,Integer> {
}
