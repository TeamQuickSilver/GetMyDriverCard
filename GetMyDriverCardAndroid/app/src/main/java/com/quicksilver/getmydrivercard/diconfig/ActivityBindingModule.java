package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;
import com.quicksilver.getmydrivercard.views.users.register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();
}
