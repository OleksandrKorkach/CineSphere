package com.media.cinesphere.security;

import com.media.cinesphere.entities.User;
import com.media.cinesphere.security.jwt.JwtUserFactory;
import com.media.cinesphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User with username " + username + " not found.");
        }

        return JwtUserFactory.create(user);
    }
}
