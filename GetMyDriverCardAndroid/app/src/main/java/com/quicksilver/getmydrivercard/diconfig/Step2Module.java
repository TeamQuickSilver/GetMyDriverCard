package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.step2.ChangeCardFragment;
import com.quicksilver.getmydrivercard.views.step2.LostStolenMalfunctionCardFragment;
import com.quicksilver.getmydrivercard.views.step2.NewCardFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class Step2Module {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract NewCardFragment newCardFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LostStolenMalfunctionCardFragment lostStolenMalfunctionCardFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ChangeCardFragment changeCardFragment();

//    @ActivityScoped
//    @Binds
//    abstract Step1Contracts.Presenter presenter(Step1Presenter step1Presenter);
}
