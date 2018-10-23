package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.models.User;

import java.io.IOException;

public interface UserRepository {

    boolean login(User user) throws IOException;

    User register(User user) throws IOException;

    User getByEmail(String email) throws IOException;
}
