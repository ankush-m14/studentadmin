package com.ankush.studentadmin.service;

import com.ankush.studentadmin.dto.UserRegistrationDTO;
import com.ankush.studentadmin.model.User;
import com.ankush.studentadmin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(UserRegistrationDTO registrationDTO) {
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setRole(registrationDTO.getRole().toUpperCase()); // Ensure the role is uppercase
        return userRepository.save(user);
    }

}
