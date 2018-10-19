package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean login(User user);

    User register(User user);

}
