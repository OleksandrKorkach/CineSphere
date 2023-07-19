package com.media.cinesphere.services.impl;

import com.media.cinesphere.entities.User;
import com.media.cinesphere.repositories.UserRepository;
import com.media.cinesphere.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}

