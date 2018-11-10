package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.views.users.home.HomeActivity;
import com.quicksilver.getmydrivercard.views.preview.PreviewActivity;
import com.quicksilver.getmydrivercard.views.requests.RequestsActivity;
import com.quicksilver.getmydrivercard.views.start.StartApplicationActivity;
import com.quicksilver.getmydrivercard.views.step1.Step1Activity;
import com.quicksilver.getmydrivercard.views.step2.NewCardActivityDocuments;
import com.quicksilver.getmydrivercard.views.step2.NewCardPart3Activity;
import com.quicksilver.getmydrivercard.views.step2.Step2Activity;
import com.quicksilver.getmydrivercard.views.step3.ProvidePhotoActivity;
import com.quicksilver.getmydrivercard.views.step4.Step4Activity;
import com.quicksilver.getmydrivercard.views.users.login.LoginActivity;
import com.quicksilver.getmydrivercard.views.users.register.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = Step1Module.class)
    abstract Step1Activity step1Activity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = Step4Module.class)
    abstract Step4Activity step4Activity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = RequestsModule.class)
    abstract RequestsActivity requestsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = Step2Module.class)
    abstract Step2Activity step2Activity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = Step2Module.class)
    abstract NewCardActivityDocuments newCardActivityDocuments();

    @ActivityScoped
    @ContributesAndroidInjector(modules = Step2Module.class)
    abstract NewCardPart3Activity newCardPart3Activity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = PreviewModule.class)
    abstract PreviewActivity previewActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = ProvidePhotoModule.class)
    abstract ProvidePhotoActivity providePhotoActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = StartApplicationModule.class)
    abstract StartApplicationActivity startApplicationActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();
}
