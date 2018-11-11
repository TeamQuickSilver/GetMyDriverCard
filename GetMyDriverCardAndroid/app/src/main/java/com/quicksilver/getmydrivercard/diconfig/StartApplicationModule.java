package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.start.StartApplicationContracts;
import com.quicksilver.getmydrivercard.views.start.StartApplicationFragment;
import com.quicksilver.getmydrivercard.views.start.StartApplicationPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StartApplicationModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StartApplicationFragment startApplicationFragment();

    @ActivityScoped
    @Binds
    abstract StartApplicationContracts.Presenter presenter(StartApplicationPresenter presenter);
}
