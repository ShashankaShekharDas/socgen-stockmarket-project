package com.shashanka.dao;

import com.shashanka.entities.StockExchange;
import org.springframework.data.repository.CrudRepository;

public interface StockExchangeRepository extends CrudRepository<StockExchange,String> {
}
