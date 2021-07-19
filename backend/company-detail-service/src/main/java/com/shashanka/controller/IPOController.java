package com.shashanka.controller;

import com.shashanka.dtos.IPO;
import com.shashanka.dtos.IPOResponse;
import com.shashanka.service.IPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class IPOController {

    @Autowired
    private IPOService ipoService;

    @PostMapping("/admin/addIPO")
    public ResponseEntity<IPOResponse> addIPO(@RequestBody IPO ipo)
    {
        return ipoService.addIPO(ipo);
    }

    @GetMapping("/user/viewIPO/{companyId}")
    public Optional<com.shashanka.entities.IPO> getIPO(@PathVariable String companyId)
    {
        return ipoService.getIPO(companyId);
    }
}
