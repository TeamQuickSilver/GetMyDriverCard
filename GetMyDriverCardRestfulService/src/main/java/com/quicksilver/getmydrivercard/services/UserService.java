package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.User;

public interface UserService {

    boolean login(User user);

    User register(User user);

}
