package com.car_rental.dto;

public class AuthenticationResponseDto {

    private String token;
    public AuthenticationResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
