package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.users.login.LoginContracts;
import com.quicksilver.getmydrivercard.views.users.login.LoginFragment;
import com.quicksilver.getmydrivercard.views.users.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ActivityScoped
    @Binds
    abstract LoginContracts.Presenter presenter(LoginPresenter loginPresenter);
}
