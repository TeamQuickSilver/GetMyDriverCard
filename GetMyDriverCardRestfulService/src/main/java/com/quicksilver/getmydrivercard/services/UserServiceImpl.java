package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.repositories.UserRepository;
import com.quicksilver.getmydrivercard.utils.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

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
        UserDetails userDetails = loadUserByUsername(user.getEmail());

        return userDetails != null && passwordEncoder.matches(user.getPassword(), userDetails.getPassword());
    }

    @Override
    public User register(User user) {
        if(loadUserByEmail(user.getEmail()) != null) {
            return null;
        }

        // Only with custom register
        if(user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // Applied also with Facebook or Google login
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }

    public UserDetails loadUserByEmail(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(username);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new HashSet<>()
        );

        return userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
