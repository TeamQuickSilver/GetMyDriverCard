package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.http.HttpRequester;
import com.quicksilver.getmydrivercard.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("serverUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
