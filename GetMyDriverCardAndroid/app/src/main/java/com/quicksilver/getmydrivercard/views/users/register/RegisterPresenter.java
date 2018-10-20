package com.quicksilver.getmydrivercard.views.users.register;


import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.services.UserService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;


public class RegisterPresenter implements RegisterContracts.Presenter {

    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;
    private RegisterContracts.View mView;

    @Inject
    public RegisterPresenter(UserService userService, SchedulerProvider schedulerProvider) {
        this.mUserService = userService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(RegisterContracts.View view) {
        mView = view;
    }

    @Override
    public void register(User user) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
            mUserService.register(user);
            emitter.onNext(user);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(v -> mView.navigateToStep1(), error -> mView.showError(error));
    }
}

