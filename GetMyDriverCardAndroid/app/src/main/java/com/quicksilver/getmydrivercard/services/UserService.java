package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.models.User;

import java.io.IOException;

public interface UserService {
    boolean login(User user) throws IOException;

    User register(User user) throws IOException;
}
