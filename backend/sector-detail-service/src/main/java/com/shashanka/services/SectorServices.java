package com.shashanka.services;

import com.shashanka.dao.SectorRepository;
import com.shashanka.dtos.CompanySectorDTO;
import com.shashanka.dtos.StockDTO;
import com.shashanka.entities.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectorServices {

    @Autowired
    SectorRepository sectorRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<Sector> getCompany(String sectorId) {
        return sectorRepository.findById(sectorId);
    }

    public List<StockDTO> getSectorPrice(String sectorId, String fromPeriod, String toPeriod, int periodicity) {


        List<StockDTO> periodicStockQuery = new ArrayList<StockDTO>();


//        Periodicity cant be 0, check for that
        periodicity = Integer.max(5,periodicity);
        periodicity /= 5;

        LocalDateTime fromPeriodDate = LocalDateTime.parse(fromPeriod);
        LocalDateTime toPeriodDate = LocalDateTime.parse(toPeriod);

        String queryCompanySector = "SELECT company_name_name FROM COMPANYSECTOR " +
                                    "WHERE SECTOR_ID_ID = ?";

        List<CompanySectorDTO> companySector = jdbcTemplate.query(queryCompanySector, new Object[]{sectorId}, new BeanPropertyRowMapper<CompanySectorDTO>(CompanySectorDTO.class));

        for(CompanySectorDTO companySectorName : companySector) {
            String companySelector = "SELECT * FROM STOCK " +
                                     "WHERE COMPANY_NAME_NAME = ? ";
            List<StockDTO> stockQuery = jdbcTemplate.query(companySelector, new Object[]{companySectorName.getCompany_name_name()}, new BeanPropertyRowMapper<StockDTO>(StockDTO.class));

            if(!stockQuery.isEmpty())
                for(int i = 0;i< stockQuery.size();i += periodicity)
                    periodicStockQuery.add(stockQuery.get(i));
        }
        return periodicStockQuery;
    }
}