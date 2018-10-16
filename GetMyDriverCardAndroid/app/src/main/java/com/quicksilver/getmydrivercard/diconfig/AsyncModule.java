package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.async.AsyncSchedulerProvider;
import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}
