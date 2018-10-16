package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.step1.Step1Contracts;
import com.quicksilver.getmydrivercard.views.step1.Step1Fragment;
import com.quicksilver.getmydrivercard.views.step1.Step1Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class Step1Module {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract Step1Fragment step1Fragment();

    @ActivityScoped
    @Binds
    abstract Step1Contracts.Presenter presenter(Step1Presenter step1Presenter);
}
