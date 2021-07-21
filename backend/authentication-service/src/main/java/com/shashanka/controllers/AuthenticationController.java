package com.shashanka.controllers;

import com.shashanka.dtos.UserLogin;
import com.shashanka.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/{type}")
    public ResponseEntity login(@RequestBody UserLogin userLogin, @PathVariable String type){
        if(type.equals("user") || type.equals("admin")) return authenticationService.login(userLogin,"user");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid type "+type);
    }

}
