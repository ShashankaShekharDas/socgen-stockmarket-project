package com.shashanka.controllers;

import com.shashanka.dtos.UserLogin;
import com.shashanka.services.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/{type}")
    @ApiOperation(value = "Logs in user based on type of user",
                    notes = "Pass login info through POST, passwords SHA256 10 rounds, pass the user type in path",
                    response = ResponseEntity.class)
    public ResponseEntity login(@ApiParam(value = "Login Info through POST",required = true) @RequestBody UserLogin userLogin,@ApiParam(value = "Type of user to login", required = true) @PathVariable String type){
        if(type.equals("user") || type.equals("admin")) return authenticationService.login(userLogin,type);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid type "+type);
    }
}
