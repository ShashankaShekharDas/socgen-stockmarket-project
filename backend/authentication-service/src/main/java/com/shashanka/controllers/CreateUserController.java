package com.shashanka.controllers;

import com.shashanka.entities.UserDB;
import com.shashanka.services.CreateUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/register")
@RestController
public class CreateUserController {

    @Autowired
    CreateUserService createUserService;

    @PostMapping("/{type}")
    @ApiOperation(value = "Registers user based on info and type",
            notes = "Pass User Info to register along with type",
            response = ResponseEntity.class)
    public ResponseEntity createUser(@RequestBody UserDB user, @PathVariable String type){
        if(type.equals("user") || type.equals("admin"))
            return createUserService.createUser(user,type);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid option to create user of type "+type+" expected user or admin");
    }
}
