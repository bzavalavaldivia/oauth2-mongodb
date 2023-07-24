package com.test.authserver.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateUserDto {
    private String username;

    private String password;

    private List<String> roles;
}
