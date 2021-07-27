package com.shashanka.repositories;

import com.shashanka.entities.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<StockExchange, String> {
}
