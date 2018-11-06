package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.preview.PreviewContracts;
import com.quicksilver.getmydrivercard.views.preview.PreviewFragment;
import com.quicksilver.getmydrivercard.views.preview.PreviewPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PreviewModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract PreviewFragment previewFragment();

    @ActivityScoped
    @Binds
    abstract PreviewContracts.Presenter presenter(PreviewPresenter presenter);
}
