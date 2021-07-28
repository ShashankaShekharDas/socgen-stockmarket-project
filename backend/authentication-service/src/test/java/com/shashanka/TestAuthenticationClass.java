package com.shashanka;

import com.shashanka.repositories.UserDBRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
public class TestAuthenticationClass {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private UserDBRepository userDBRepository;

    @Test
    public void AuthenticationServiceTest(){

    }
}
