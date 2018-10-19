package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.http.HttpRequester;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.parsers.JsonParser;
import com.quicksilver.getmydrivercard.repositories.HttpUsersRepository;
import com.quicksilver.getmydrivercard.repositories.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public UserRepository userRepository(HttpRequester httpRequester, JsonParser<User> jsonParser,
                                         @Named("serverUrl") String serverUrl) {
        return new HttpUsersRepository(httpRequester, jsonParser, serverUrl);
    }
}
