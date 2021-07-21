package com.shashanka.service;

import com.shashanka.entities.Company;
import com.shashanka.entities.Stock;
import com.shashanka.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyDetailService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Iterable<Company> getCompany(){
        return companyRepository.findAll();
    }

    public List<Company> getCompanyDetails(String companyName){

        String sql = "select * from company where name = ?";
        return jdbcTemplate.query(sql,new Object[]{companyName},new BeanPropertyRowMapper<Company>(Company.class));
    }

    public List<Stock> retrievePeriodData(String companyId,String exchangeID, String periodFrom, String periodTo, int periodicity)
    {
        /*
        Format for DateTime yyyy-mm-ddThh:mm:ss
         */
        LocalDateTime periodFromDate = LocalDateTime.parse(periodFrom);
        LocalDateTime periodToDate = LocalDateTime.parse(periodTo);

        periodicity = periodicity/5;
        List<Stock> lst = jdbcTemplate.query("select PRICE,date_time from stock where exchange_id_id = ?  AND company_code = ? AND DATE_TIME > ? AND DATE_TIME < ? ORDER BY ID ASC",new Object[]{exchangeID,companyId,periodFromDate,periodToDate},new BeanPropertyRowMapper<Stock>(Stock.class));
        List<Stock> periodicListQuery = new ArrayList<Stock>();

        for (int i = 0;i<lst.size();i += periodicity)
            periodicListQuery.add(lst.get(i));
        return periodicListQuery;
    }

    public List<Company> getCompanyNames(String pattern){
        return jdbcTemplate.query("SELECT * FROM COMPANY WHERE NAME LIKE '"+pattern+"%'",new BeanPropertyRowMapper<Company>(Company.class));
    }
}
