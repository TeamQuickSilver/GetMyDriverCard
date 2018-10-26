package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.users.register.RegisterContracts;
import com.quicksilver.getmydrivercard.views.users.register.RegisterFragment;
import com.quicksilver.getmydrivercard.views.users.register.RegisterPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RegisterModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RegisterFragment userFragment();

    @ActivityScoped
    @Binds
    abstract RegisterContracts.Presenter presenter(RegisterPresenter registerPresenter);
}
