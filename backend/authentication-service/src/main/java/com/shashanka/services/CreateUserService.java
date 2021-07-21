package com.shashanka.services;

import com.shashanka.entities.UserDB;
import com.shashanka.repository.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    UserDBRepository userDBRepository;

    public ResponseEntity createUser(UserDB user, String type){
        try {
            user.setConfirmed(false);
            if (type.equals("admin")) user.setConfirmed(true);
            user.setType(type);
            userDBRepository.save(user);
            return ResponseEntity.ok("User created Successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't create user. Please check input parameters and try again");
        }
    }
}
