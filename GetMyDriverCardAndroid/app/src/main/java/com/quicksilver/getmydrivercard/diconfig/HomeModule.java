package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.users.home.HomeContracts;
import com.quicksilver.getmydrivercard.views.users.home.HomeFragment;
import com.quicksilver.getmydrivercard.views.users.home.HomePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @ActivityScoped
    @Binds
    abstract HomeContracts.Presenter presenter(HomePresenter homePresenter);
}
