package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Role;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.repositories.RoleRepository;
import com.quicksilver.getmydrivercard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(User user) {
        User returnedUser = getByEmail(user.getEmail());

        return returnedUser != null && passwordEncoder.matches(user.getPassword(), returnedUser.getPassword());
    }

    @Override
    public User register(User user) {
        if(getByEmail(user.getEmail()) != null) {
            return null;
        }

        // Only with custom register
        if(user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // Applied also with Facebook or Google login
//        Role role = new Role("USER");
        user.setRole(roleRepository.getByRoleId(1L));
        return userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
