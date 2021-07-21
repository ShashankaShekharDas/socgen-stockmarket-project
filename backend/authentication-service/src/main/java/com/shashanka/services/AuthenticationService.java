package com.shashanka.services;

import com.shashanka.dtos.UserLogin;
import com.shashanka.entities.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ResponseEntity login(UserLogin userLogin, String type)
    {
        try {
            String sql = "SELECT * FROM USERDB WHERE " +
                    "user_name = ? AND " +
                    "password = ? AND " +
                    "type = ? AND " +
                    "CONFIRMED = TRUE";
            List<UserDB> query = jdbcTemplate.query(sql, new Object[]{userLogin.getUsername(), userLogin.getPassword(), type}, new BeanPropertyRowMapper<UserDB>(UserDB.class));

            return ResponseEntity.ok(query.size() >= 1);
        }
        catch (Exception e)
        {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Parameters sent");
        }
    }
}

