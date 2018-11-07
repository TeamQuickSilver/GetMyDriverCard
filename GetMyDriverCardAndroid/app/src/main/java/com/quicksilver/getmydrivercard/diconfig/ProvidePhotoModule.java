package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.step3.CameraFragment;
import com.quicksilver.getmydrivercard.views.step3.DrivingLicensePhotoActivity;
import com.quicksilver.getmydrivercard.views.step3.IdCardPhotoActivity;
import com.quicksilver.getmydrivercard.views.step3.PreviousCardPhotoActivity;
import com.quicksilver.getmydrivercard.views.step3.Step3Contracts;
import com.quicksilver.getmydrivercard.views.step3.Step3Presenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ProvidePhotoModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CameraFragment cameraFragment();

    @ContributesAndroidInjector
    abstract PreviousCardPhotoActivity previousCardPhotoActivity();

    @ContributesAndroidInjector
    abstract DrivingLicensePhotoActivity drivingLicensePhotoActivity();

    @ContributesAndroidInjector
    abstract IdCardPhotoActivity idCardPhotoActivity();

    @ActivityScoped
    @Binds
    abstract Step3Contracts.Presenter presenter(Step3Presenter step3Presenter);
}
