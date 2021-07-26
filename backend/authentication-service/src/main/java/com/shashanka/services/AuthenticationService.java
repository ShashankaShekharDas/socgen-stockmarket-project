package com.shashanka.services;

import com.shashanka.config.JwtTokenUtil;
import com.shashanka.dtos.LoginResponse;
import com.shashanka.dtos.UserLogin;
import com.shashanka.entities.UserDB;
import com.shashanka.repository.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserDBRepository userDBRepository;

    @Autowired
    UserAuth userAuth;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity login(UserLogin userLogin, String type)
    {
        UserDetails userDetails = userAuth.loadUserByUsername(userLogin.getUsername());
        if(userDetails == null || !passwordEncoder.matches(userLogin.getPassword(), userDetails.getPassword()))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }
        String token = jwtTokenUtil.generateToken(userDetails);
        long expire = (jwtTokenUtil.getExpirationDateFromToken(token).getTime()-(new Date()).getTime());
        boolean isAdmin = userDetails.getAuthorities().contains(new SimpleGrantedAuthority("admin"));
        return ResponseEntity.ok(new LoginResponse(userDetails.getUsername(), token, isAdmin, expire));

    }
}

