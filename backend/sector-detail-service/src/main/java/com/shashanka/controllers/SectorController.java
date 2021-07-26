package com.shashanka.controllers;

import com.shashanka.dtos.StockDTO;
import com.shashanka.entities.Sector;
import com.shashanka.services.SectorServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/sector")
@RestController
public class SectorController {

    @Autowired
    private SectorServices sectorServices;

    @GetMapping("/{sectorId}")
    @ApiOperation(value = "Get sector details",
                  notes = "Get details of the sector",
                  response = ResponseEntity.class)
    public ResponseEntity getSector(@PathVariable String sectorId){
        Optional<Sector> company = sectorServices.getSector(sectorId);
        if(company.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such sector "+sectorId);
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

    @PostMapping
    @ApiOperation(value = "Add sector",
                  notes = "Add sector to db, pass sector object through body",
                  response = ResponseEntity.class)
    public ResponseEntity addSector(@RequestBody Sector sector){
        return sectorServices.addSector(sector);
    }

    @GetMapping("/company/{sectorId}")
    @ApiOperation(value = "Get company in sector",
            notes = "Get details of company in sector, pass sector id",
            response = ResponseEntity.class)
    public ResponseEntity getCompany(@PathVariable String sectorId){
        return sectorServices.getCompany(sectorId);
    }

}
