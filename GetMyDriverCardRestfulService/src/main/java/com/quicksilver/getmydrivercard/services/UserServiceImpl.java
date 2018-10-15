package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.repositories.UserRepository;
import com.quicksilver.getmydrivercard.utils.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(User user) {
        User userToLogin = userRepository.findFirstByUsername(user.getUsername());

        String cryptedPassword = passwordEncoder.encode(user.getPassword());

        return userToLogin != null && userToLogin.getPassword().equals(cryptedPassword);
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }
}
