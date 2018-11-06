package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.preview.PreviewContracts;
import com.quicksilver.getmydrivercard.views.preview.PreviewPresenter;
import com.quicksilver.getmydrivercard.views.step1.Step1Contracts;
import com.quicksilver.getmydrivercard.views.step1.Step1Presenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PreviewModule {

    @ActivityScoped
    @Binds
    abstract PreviewContracts.Presenter presenter(PreviewPresenter presenter);
}
