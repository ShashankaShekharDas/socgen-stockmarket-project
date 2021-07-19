package com.shashanka.dtos;

import lombok.Data;

@Data
public class Response {
    private boolean status;
    private String error;
    private String message;
}
