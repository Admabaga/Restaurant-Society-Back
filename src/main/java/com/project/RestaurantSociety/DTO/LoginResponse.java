package com.project.RestaurantSociety.DTO;

public class LoginResponse {
    private String jwt;
    private Long userId;

    public LoginResponse(String jwt, Long userId) {
        this.jwt = jwt;
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public Long getUserId() {
        return userId;
    }
}
