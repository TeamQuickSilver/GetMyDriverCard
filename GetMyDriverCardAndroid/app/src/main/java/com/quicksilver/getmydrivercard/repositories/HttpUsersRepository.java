package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.http.HttpRequester;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.parsers.JsonParser;

import java.io.IOException;

public class HttpUsersRepository implements UserRepository {
    private final HttpRequester mHttpRequester;
    private final JsonParser<User> mJsonParser;
    private final String mLoginUrl;
    private final String mRegisterUrl;

    public HttpUsersRepository(HttpRequester httpRequester, JsonParser<User> jsonParser, String serverUrl) {
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
        mLoginUrl = serverUrl + "/users/login";
        mRegisterUrl = serverUrl + "/users/register";
    }

    @Override
    public boolean login(User user) throws IOException {
        String requestBody = mJsonParser.toJson(user);
        String responseBody = mHttpRequester.post(mLoginUrl, requestBody);

        return Boolean.valueOf(responseBody);
    }

    @Override
    public User register(User user) throws IOException {
        String requestBody = mJsonParser.toJson(user);
        String responseBody = mHttpRequester.post(mLoginUrl, requestBody);

        return mJsonParser.fromJson(responseBody);
    }
}
