package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.parsers.GsonJsonParser;
import com.quicksilver.getmydrivercard.parsers.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    JsonParser<User> userJsonParser() {
        return new GsonJsonParser<>(User.class, User[].class);
    }

    @Provides
    JsonParser<Application> applicationJsonParser() {
        return new GsonJsonParser<>(Application.class, Application[].class);
    }
}
