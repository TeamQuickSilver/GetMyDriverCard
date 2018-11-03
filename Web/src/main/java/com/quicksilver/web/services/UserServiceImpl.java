package com.quicksilver.web.services;

import com.quicksilver.web.models.User;
import com.quicksilver.web.models.UserRole;
import com.quicksilver.web.repositories.UserRepository;
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
        User returnedUser = getByEmail(user.getEmail());

        return returnedUser != null && returnedUser.getRole().equals(UserRole.ADMIN)
                && user.getPassword().equals(returnedUser.getPassword());
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findFirstByEmail(email);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new HashSet<>()
        );

        return userDetails;
    }
}
