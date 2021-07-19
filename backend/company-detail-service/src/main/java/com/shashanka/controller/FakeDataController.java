package com.shashanka.controller;

import com.shashanka.service.FakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/faker")
@RestController
public class FakeDataController {

    @Autowired
    private FakerService fakerService;

    @GetMapping("/{companyCode}/{exchangeId}")
    public boolean fakeDataCreate(@PathVariable String companyCode, @PathVariable String exchangeId)
    {
        return fakerService.addStock(companyCode,exchangeId);
    }
}
