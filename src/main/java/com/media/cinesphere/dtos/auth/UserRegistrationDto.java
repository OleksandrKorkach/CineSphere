package com.media.cinesphere.dtos.auth;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.entities.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationDto {
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

    public User toUser(){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}
