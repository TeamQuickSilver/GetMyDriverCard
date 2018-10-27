package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.http.HttpRequester;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.parsers.JsonParser;
import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
import com.quicksilver.getmydrivercard.repositories.HttpApplicationRepository;
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

    @Provides
    @Singleton
    public ApplicationRepository applicationRepository(
            HttpRequester httpRequester, JsonParser<Application> applicationJsonParser,
            JsonParser<User> userJsonParser, @Named("serverUrl") String serverUrl) {
        return new HttpApplicationRepository(httpRequester, applicationJsonParser, userJsonParser, serverUrl);
    }
}
