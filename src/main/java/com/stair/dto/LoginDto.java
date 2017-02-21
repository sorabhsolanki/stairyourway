package com.stair.dto;

import org.hibernate.validator.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;


    public LoginDto() {
    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
