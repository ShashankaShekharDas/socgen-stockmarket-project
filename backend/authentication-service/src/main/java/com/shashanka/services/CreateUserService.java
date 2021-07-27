package com.shashanka.services;

import com.shashanka.dtos.UserLogin;
import com.shashanka.entities.UserDB;
import com.shashanka.repository.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserDBRepository userDBRepository;

    public ResponseEntity createUser(UserDB user, String type){

        if(userDBRepository.findByUserName(user.getUserName()) != null || userDBRepository.findByEmail(user.getEmail())!= null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or email already exists");

        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setType(type);
            user.setConfirmed(false);
            if (type.equals("admin")) user.setConfirmed(true);
            userDBRepository.save(user);
            return ResponseEntity.ok("Successfully registered");
        }
        catch (Exception e)
        {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt store user");
        }

    }

    public ResponseEntity updateUser(UserLogin userLogin){
        try {
            UserDB byUserName = userDBRepository.findByUserName(userLogin.getUsername());
            byUserName.setPassword(passwordEncoder.encode(userLogin.getPassword()));
            userDBRepository.save(byUserName);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't Update Password");
        }
    }
}
