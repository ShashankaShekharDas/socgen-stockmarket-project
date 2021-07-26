package com.shashanka.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private String token;
    private boolean isAdmin;
    private long expire;
}
