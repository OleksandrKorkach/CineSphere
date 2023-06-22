package com.media.cinesphere.services;

import com.media.cinesphere.dtos.auth.UserRegistrationDto;
import com.media.cinesphere.dtos.user.UserProfileDto;
import com.media.cinesphere.entities.User;

public interface UserService {

    User getUserByUsername(String username);

    void register(UserRegistrationDto userRegistrationDto);

    UserProfileDto getUserProfileById(Long id);

}
