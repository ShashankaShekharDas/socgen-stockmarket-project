package com.shashanka.repository;

import com.shashanka.entities.UserDB;
import org.springframework.data.repository.CrudRepository;

public interface UserDBRepository extends CrudRepository<UserDB,Integer> {
    public UserDB findByEmail(String email);
    public UserDB findByUserName(String username);
}
