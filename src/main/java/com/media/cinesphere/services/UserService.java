package com.media.cinesphere.services;

import com.media.cinesphere.entities.User;

public interface UserService {
    User getUserByUsername(String username);
}
