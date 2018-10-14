package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.MainActivity;

import dagger.Module;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    //@ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity exampleActivity();

}
