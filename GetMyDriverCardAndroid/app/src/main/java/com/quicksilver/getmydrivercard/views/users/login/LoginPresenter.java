package com.quicksilver.getmydrivercard.views.users.login;

import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.models.UserRole;
import com.quicksilver.getmydrivercard.services.UserService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContracts.Presenter {
    private LoginContracts.View mView;
    private final UserService mUserService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public LoginPresenter(UserService mUserService, SchedulerProvider mSchedulerProvider) {
        this.mUserService = mUserService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }

    @Override
    public void login(boolean isLoginSucceeded, User user) {
        if (!isLoginSucceeded) {
            return;
        }

        Observable<User> observable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
//            mUserService.login(user);
            User returnedUser = mUserService.getByEmail(user.getEmail());
            emitter.onNext(returnedUser);
            emitter.onComplete();
        });

        Disposable subscriptionUser = observable.filter(u -> u.getRole() == UserRole.USER)
        .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(v -> mView.navigateToStep1(), error -> mView.showError(error));

        Disposable subscriptionAdmin = observable.filter(u -> u.getRole() == UserRole.ADMIN)
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(v -> mView.navigateToRequests(), error -> mView.showError(error));
    }

    @Override
    public void registerGoogleOrFacebookUser(User user) {

    }

//    @Override
//    public void login(User user) {
//        Disposable disposable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
//            mUserService.login(user);
//            emitter.onNext(user);
//            emitter.onComplete();
//        }).subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(v -> mView.navigateToStep1(), error -> mView.showError(error));
//    }
}

