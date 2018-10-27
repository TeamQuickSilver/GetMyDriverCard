package com.quicksilver.getmydrivercard.diconfig;

import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
import com.quicksilver.getmydrivercard.repositories.UserRepository;
import com.quicksilver.getmydrivercard.services.ApplicationService;
import com.quicksilver.getmydrivercard.services.HttpApplicationService;
import com.quicksilver.getmydrivercard.services.HttpUserService;
import com.quicksilver.getmydrivercard.services.UserService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public UserService usersService(UserRepository repository) {
        return new HttpUserService(repository);
    }

    @Provides
    public ApplicationService applicationService(ApplicationRepository repository) {
        return new HttpApplicationService(repository);
    }
}
