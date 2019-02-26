package com.visu.tutorial.security.payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String name;
    private String password;
}
