package com.shashanka.service;

import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.entities.Company;
import com.shashanka.repositories.CompanyRepository;
import com.shashanka.repositories.IPORepository;
import com.shashanka.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPOService {

    @Autowired
    StockExchangeRepository stockExchangeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    IPORepository ipoRepository;

    public ResponseEntity<IPOResponse> addIPO(IPO ipo)
    {
        IPOResponse ipoResponse = new IPOResponse();
        try {

            com.shashanka.entities.IPO ipoDetails = new com.shashanka.entities.IPO(ipo.getId(), ipo.getPrice(), ipo.getCountShares(), ipo.getOpeningDateTime(), ipo.getRemarks(), stockExchangeRepository.findById(ipo.getExchangeId()).get(), companyRepository.findById(ipo.getId()).get());
            Company companyIPO = companyRepository.findById(ipo.getId()).get();
            companyIPO.setListed(true);
            companyRepository.save(companyIPO);
            ipoRepository.save(ipoDetails);
            ipoResponse.setStatus(true);
            ipoResponse.setMessage("IPO Added Successfully");
            return ResponseEntity.ok(ipoResponse);
        }
        catch (Exception e)
        {
            ipoResponse.setStatus(false);
            ipoResponse.setError("Invalid Input");
            return new ResponseEntity<IPOResponse>(ipoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    public Optional<com.shashanka.entities.IPO> getIPO(int companyId)
    {
        return ipoRepository.findById(companyId);
    }
}
