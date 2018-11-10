package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.step2.ChangeCardFragment;
import com.quicksilver.getmydrivercard.views.step2.ExchangeCardFragment;
import com.quicksilver.getmydrivercard.views.step2.LostStolenMalfunctionCardFragment;
import com.quicksilver.getmydrivercard.views.step2.NewCardFragment;
import com.quicksilver.getmydrivercard.views.step2.NewCardFragmentDocuments;
import com.quicksilver.getmydrivercard.views.step2.NewCardPart3Fragment;
import com.quicksilver.getmydrivercard.views.step2.RenewCardFragment;
import com.quicksilver.getmydrivercard.views.step2.Step2Contracts;
import com.quicksilver.getmydrivercard.views.step2.Step2Presenter;

import dagger.Binds;
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

    @FragmentScoped
    @ContributesAndroidInjector
    abstract NewCardFragmentDocuments newCardFragmentDocuments();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract RenewCardFragment renewCardFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ExchangeCardFragment exchangeCardFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract NewCardPart3Fragment newCardPart3Fragment();

//    @ContributesAndroidInjector
//    abstract Step2Activity step2Activity();
//
//    @ContributesAndroidInjector
//    abstract NewCardActivityDocuments newCardActivityDocuments();
//
//    @ContributesAndroidInjector
//    abstract NewCardPart3Activity newCardPart3Activity();

    @ActivityScoped
    @Binds
    abstract Step2Contracts.Presenter presenter(Step2Presenter step2Presenter);
}
