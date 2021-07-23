package com.shashanka.controller;

import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.service.IPOService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/IPO")
@RestController
public class IPOController {

    private IPOService ipoService;

    @Autowired
    public IPOController(IPOService ipoService)
    {
        this.ipoService = ipoService;
    }

    @PostMapping
    @ApiOperation(value = "Adds IPO",
                  notes = "Adds IPO to db requires IPO class from body",
                  response = ResponseEntity.class)
    public ResponseEntity<IPOResponse> addIPO(@RequestBody IPO ipo)
    {
        return ipoService.addIPO(ipo);
    }

    @GetMapping("/{companyId}")
    @ApiOperation(value = "Get IPO by company ID",
                  notes = "Gets all details of the IPO based on the company ID",
                  response = ResponseEntity.class)
    public ResponseEntity getIPO(@PathVariable int companyId)
    {
        return ipoService.getIPO(companyId);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Update IPO",
                  notes = "Update IPO in the table. Pass IPO class as parameter",
                  response = ResponseEntity.class)
    public ResponseEntity updateIPO(@RequestBody IPO ipo)
    {
        return ipoService.updateIPO(ipo);
    }

    @GetMapping("/chronology")
    @ApiOperation(value = "Get IPO in chronological order",
                  notes = "Get IPO in chronological order",
                  response = ResponseEntity.class)
    public ResponseEntity getChronologyIPO(){
        return ipoService.getChronology();
    }

}
