package com.shashanka.services;

import com.shashanka.entities.Company;
import com.shashanka.entities.Stock;
import com.shashanka.entities.StockExchange;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.StockPriceRepository;
import com.shashanka.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
@Service
public class ExchangeService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockPriceRepository stockPriceRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<StockExchange> getStockExchanges() {
        System.out.println(stockRepository.findAll());
        return stockRepository.findAll();
    }

    public StockExchange addStockExchange(StockExchange stockExchange) {
        StockExchange save = stockRepository.save(stockExchange);
        return save;
    }

    public Optional<StockExchange> getExchange(String id)
    {
        return stockRepository.findById(id);
    }

    public ResponseEntity deleteExchange(String id)
    {

        try {
            if(stockRepository.findById(id).isEmpty())throw new Exception("Exchange not found");
            stockRepository.deleteById(id);
            return ResponseEntity.ok("Exchange Deleted Succesfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt delete exchange");
        }
    }

    public ResponseEntity getStock(String exchangeId){
        try {
            String sql = "SELECT DISTINCT company_code FROM STOCK WHERE exchange_id_id = ?";
            List<Stock> query = jdbcTemplate.query(sql, new Object[]{exchangeId}, new BeanPropertyRowMapper<Stock>(Stock.class));
            List<Company> companyList = new ArrayList<>();
            for(Stock stock:query)
                companyList.add(companyRepository.findById(stock.getCompanyCode()).get());
            return ResponseEntity.ok(companyList);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt find by exchange ID"+exchangeId);
        }
    }
}
