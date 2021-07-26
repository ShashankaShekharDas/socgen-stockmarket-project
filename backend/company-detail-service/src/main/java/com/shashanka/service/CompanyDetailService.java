package com.shashanka.service;

import com.shashanka.dtos.CompanySectorDTO;
import com.shashanka.dtos.DirectorDTO;
import com.shashanka.entities.*;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.CompanySectorRepository;
import com.shashanka.repositories.DirectorRepository;
import com.shashanka.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDetailService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private CompanySectorRepository companySectorRepository;

    @Autowired
    private SectorRepository sectorRepository;

    public Iterable<Company> getCompany(){
        return companyRepository.findAll();
    }

    public ResponseEntity getCompanyDetails(int companyId){

        try {
            return ResponseEntity.ok(companyRepository.findById(companyId));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cant find company");
        }
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

    public ResponseEntity addCompany(Company company){
        try {
            companyRepository.save(company);
            return ResponseEntity.ok("Company Added Successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt add company");
        }
    }

    public ResponseEntity deleteCompany(Integer code)
    {
        try {
            companyRepository.deleteById(code);
            return ResponseEntity.ok("Deleted company successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cant delete with code "+String.valueOf(code));
        }
    }

    public ResponseEntity addDirector(List<DirectorDTO> directorList){
        for(DirectorDTO directorDTO:directorList) {
            try {
                Optional<Company> byId = companyRepository.findById(directorDTO.getCompanyCode());
                directorRepository.save(new Director(byId.get(), directorDTO.getDirectorName()));
            }
            catch (Exception e)
            {

            }
        }

        return ResponseEntity.ok("Request Completed");
    }

    public ResponseEntity viewDirector(){
        return ResponseEntity.ok(directorRepository.findAll());
    }

    public ResponseEntity viewDirectorId(int companyId)
    {
        try {
            List<Director> byCompanyCode = directorRepository.findAllByCompanyCode(companyRepository.findById(companyId).get());
            List<DirectorDTO> directorDTOS = new ArrayList<>();
            for(Director director:byCompanyCode)
            {
                directorDTOS.add(new DirectorDTO(director.getCompanyCode().getCode(),director.getDirectorName()));
            }
            return ResponseEntity.ok(directorDTOS);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such director");
        }
    }

    public ResponseEntity addSector(List<CompanySectorDTO> companySectorDTOList)
    {
        for(CompanySectorDTO companySectorDTO:companySectorDTOList) {
            try {
                CompanySector companySector = new CompanySector(companyRepository.findById(companySectorDTO.getCompany()).get(), sectorRepository.findById(companySectorDTO.getSectorId()).get());
                companySectorRepository.save(companySector);
            } catch (Exception e) {
            }
        }
        return ResponseEntity.ok("Request successful");
    }

    public ResponseEntity getCompanySector(int companyCode){
        try {
            List<CompanySector> companySectorList = companySectorRepository.findAllByCompany(companyRepository.findById(companyCode).get());
            List<Sector> sectorList = new ArrayList<>();
            for(CompanySector companySector:companySectorList)
            {
                sectorList.add(companySector.getSectorId());
            }
            return ResponseEntity.ok(sectorList);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt find company with company code "+companyCode);
        }
    }
}
