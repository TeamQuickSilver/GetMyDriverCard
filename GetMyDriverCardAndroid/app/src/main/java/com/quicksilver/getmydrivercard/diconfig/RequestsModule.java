package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.requests.RequestsContracts;
import com.quicksilver.getmydrivercard.views.requests.RequestsFragment;
import com.quicksilver.getmydrivercard.views.requests.RequestsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RequestsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RequestsFragment requestsFragment();

    @ActivityScoped
    @Binds
    abstract RequestsContracts.Presenter presenter(RequestsPresenter requestsPresenter);
}
