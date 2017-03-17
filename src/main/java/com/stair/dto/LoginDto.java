package com.stair.dto;

import org.hibernate.validator.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String organization;


    public LoginDto() {
    }

    public LoginDto(String name, String email, String password, String organization) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.organization = organization;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }
}
