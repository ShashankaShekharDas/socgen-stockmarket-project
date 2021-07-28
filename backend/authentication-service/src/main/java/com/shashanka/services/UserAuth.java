package com.shashanka.services;

import com.shashanka.entities.UserDB;
import com.shashanka.repositories.UserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserAuth implements UserDetailsService {

    @Autowired
    private UserDBRepository userDBRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDB user = userDBRepository.findByUserName(username);
        System.out.println(user);
        if(!user.isConfirmed() || user == null)
            return null;
        return new User(user.getUserName(),user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getType())));
    }

}
