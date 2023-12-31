package com.media.cinesphere.dtos.auth;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.entities.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;

    public User toUser(){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
