package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.step4.Step4Contracts;
import com.quicksilver.getmydrivercard.views.step4.Step4Fragment;
import com.quicksilver.getmydrivercard.views.step4.Step4Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class Step4Module {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract Step4Fragment step4Fragment();

    @ActivityScoped
    @Binds
    abstract Step4Contracts.Presenter presenter(Step4Presenter step4Presenter);
}
