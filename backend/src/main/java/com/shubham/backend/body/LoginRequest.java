package com.shubham.backend.body;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private String token;
}
