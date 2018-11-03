package com.quicksilver.web.services;

import com.quicksilver.web.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean login(User user);

    User getByEmail(String email);
}
