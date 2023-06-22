package com.media.cinesphere.services.impl;

import com.media.cinesphere.dtos.auth.UserRegistrationDto;
import com.media.cinesphere.dtos.user.UserProfileDto;
import com.media.cinesphere.entities.Role;
import com.media.cinesphere.entities.User;
import com.media.cinesphere.entities.enums.Status;
import com.media.cinesphere.repositories.RoleRepository;
import com.media.cinesphere.repositories.UserRepository;
import com.media.cinesphere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(UserRegistrationDto registrationDto) {
        User user = registrationDto.toUser();
        setUserRoles(user);
        setRegistrationDetails(user);
        userRepository.save(user);
    }

    @Override
    public UserProfileDto getUserProfileById(Long id) {
        User user = userRepository.getById(id);
        return UserProfileDto.fromUser(user);
    }

    public void setUserRoles(User user){
        Role userRole = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
    }

    public void setRegistrationDetails(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        user.setWasCreated(LocalDateTime.now());
        user.setUpdated(LocalDateTime.now());
    }


}
