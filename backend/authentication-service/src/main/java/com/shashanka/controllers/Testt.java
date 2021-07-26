package com.shashanka.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class Testt {
    @GetMapping
    public String get(){
        return "abc";
    }
}
