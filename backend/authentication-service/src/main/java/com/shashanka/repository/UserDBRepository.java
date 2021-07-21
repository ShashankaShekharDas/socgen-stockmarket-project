package com.shashanka.repository;

import com.shashanka.entities.UserDB;
import org.springframework.data.repository.CrudRepository;

public interface UserDBRepository extends CrudRepository<UserDB,Integer> {
}
