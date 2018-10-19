package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.repositories.UserRepository;

import java.io.IOException;

public class HttpUserService implements UserService {

    private final UserRepository mUserRepository;

    public HttpUserService(UserRepository mUserRepository) {
        this.mUserRepository = mUserRepository;
    }

    @Override
    public boolean login(User user) throws IOException {
        return mUserRepository.login(user);
    }

    @Override
    public User register(User user) throws IOException {
        return mUserRepository.register(user);
    }
}
