package com.stair.persistent.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class Login {

    private String name;

    private String email;

    private String password;

    private String organization;

    public Login(String name, String email, String password, String organization) {
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
