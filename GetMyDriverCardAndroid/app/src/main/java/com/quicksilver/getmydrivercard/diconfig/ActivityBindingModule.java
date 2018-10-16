package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();
}
