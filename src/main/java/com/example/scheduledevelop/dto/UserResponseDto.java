package com.example.scheduledevelop.dto;


import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;

    private final String emial;


    public UserResponseDto(String username, String emial) {
        this.username = username;
        this.emial = emial;
    }
}
