package com.quicksilver.getmydrivercard.diconfig;

import android.app.Application;

import com.quicksilver.getmydrivercard.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        AsyncModule.class,
        LoginModule.class,
        Step1Module.class,
        ParsersModule.class,
        HttpModule.class,
        RepositoriesModule.class
})
public interface AppComponent extends AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
