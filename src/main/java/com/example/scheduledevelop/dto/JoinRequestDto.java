package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class JoinRequestDto {

    private final String username;
    private final String password;
    private final String email;


    public JoinRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
