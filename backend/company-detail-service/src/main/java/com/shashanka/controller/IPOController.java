package com.shashanka.controller;

import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<IPOResponse> addIPO(@RequestBody IPO ipo)
    {
        return ipoService.addIPO(ipo);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity getIPO(@PathVariable int companyId)
    {
        Optional<com.shashanka.entities.IPO> ipo = ipoService.getIPO(companyId);
        if(ipo.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such IPO");
        return ResponseEntity.ok(ipo.get());
    }
}
