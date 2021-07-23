package com.shashanka.controllers;

import com.shashanka.dtos.StockDTO;
import com.shashanka.entities.Sector;
import com.shashanka.services.SectorServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/sector")
@RestController
public class SectorController {

    @Autowired
    private SectorServices sectorServices;

    @GetMapping("/{sectorId}")
    @ApiOperation(value = "Get Companies in a sector",
                  notes = "Get companies belonging to a sector, pass in a string containing sector id",
                  response = ResponseEntity.class)
    public ResponseEntity getCompany(@PathVariable String sectorId){
        Optional<Sector> company = sectorServices.getCompany(sectorId);
        if(company.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such sector "+sectorId+" or no company exists in sector");
        return ResponseEntity.ok(company.get());
    }

    @GetMapping("/{sectorId}/{fromPeriod}/{toPeriod}/{periodicity}")
    @ApiOperation(value = "Get prices of companies in sector",
                  notes = "Get prices belonging to a sector for a definite period",
                  response = ResponseEntity.class)
    public ResponseEntity getSectorPrice(@PathVariable String sectorId, @PathVariable String fromPeriod, @PathVariable String toPeriod, @PathVariable int periodicity){
        List<StockDTO> sectorPrice = sectorServices.getSectorPrice(sectorId, fromPeriod, toPeriod, periodicity);
        if(sectorPrice.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input");
        }
        return ResponseEntity.ok(sectorPrice);
    }
}
