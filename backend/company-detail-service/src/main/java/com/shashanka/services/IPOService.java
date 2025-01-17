package com.shashanka.services;

import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.entities.Company;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.IPORepository;
import com.shashanka.repositories.IpoJPA;
import com.shashanka.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPOService {

    @Autowired
    StockExchangeRepository stockExchangeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    IPORepository ipoRepository;

    @Autowired
    IpoJPA ipoJPA;

    public ResponseEntity<IPOResponse> addIPO(IPO ipo)
    {
        IPOResponse ipoResponse = new IPOResponse();
        try {
            com.shashanka.entities.IPO ipoDetails = new com.shashanka.entities.IPO(ipo.getId(), ipo.getPrice(), ipo.getCountShares(), ipo.getOpeningDateTime(), ipo.getRemarks(), stockExchangeRepository.findById(ipo.getExchangeId()).get(), companyRepository.findById(ipo.getCompanyId()).get());
            Company companyIPO = companyRepository.findById(ipo.getCompanyId()).get();
            companyIPO.setListed(true);
            companyRepository.save(companyIPO);
            ipoRepository.save(ipoDetails);
            ipoResponse.setStatus(true);
            ipoResponse.setMessage("IPO Added Successfully");
            return ResponseEntity.ok(ipoResponse);
        }
        catch (Exception e)
        {
            System.out.println(e);
            ipoResponse.setStatus(false);
            ipoResponse.setError("Invalid Input");
            return new ResponseEntity<IPOResponse>(ipoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getIPO(int companyId) {
        try {
            return ResponseEntity.ok(ipoJPA.findByCompanyId(companyRepository.findById(companyId).get()));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt find ipo with company id "+companyId);
        }
    }

    public ResponseEntity updateIPO(IPO ipo){

        try {
            com.shashanka.entities.IPO ipoDetails = ipoRepository.findById(ipo.getId()).get();
            ipoDetails.setPrice(ipo.getPrice());
            ipoDetails.setCountShares(ipo.getCountShares());
            ipoDetails.setOpeningDateTime(ipo.getOpeningDateTime());
            ipoDetails.setRemarks(ipo.getRemarks());
            ipoRepository.save(ipoDetails);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch (Exception e)
        {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt update");
        }
    }

    public ResponseEntity getChronology(){
        try {
            Iterable<com.shashanka.entities.IPO> allIPO = ipoRepository.findAll();
            List<IPO> ipoList = new ArrayList<>();
            for(com.shashanka.entities.IPO ipo:allIPO)
            {
                ipoList.add(new IPO(ipo.getId(),ipo.getPrice(),ipo.getCountShares(),ipo.getOpeningDateTime(),ipo.getRemarks(),ipo.getExchangeId().getId(),ipo.getCompanyId().getCode()));
            }
            return ResponseEntity.ok(ipoList);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No IPO");
        }
    }
}
