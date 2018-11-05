package com.quicksilver.getmydrivercard.views.users.login;

import com.quicksilver.getmydrivercard.Constants;
import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.services.UserService;

import javax.inject.Inject;

import io.reactivex.Observable;
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
    public void login(User user) {
        Observable<User> observable = Observable.create(emitter -> {
            User returnedUser = mUserService.getByEmail(user.getEmail());
            emitter.onNext(returnedUser);
            emitter.onComplete();
        });

        loginNavigation(observable);
    }

    @Override
    public void loginGoogleOrFacebookUser(User googleOrFacebookUser) {
        Observable<User> observable = Observable.create(emitter -> {
            User user = mUserService.getByEmail(googleOrFacebookUser.getEmail());
            if (user == null) {
                User userToRegister = new User(googleOrFacebookUser.getEmail());
                user = mUserService.register(userToRegister);
            }
            emitter.onNext(user);
            emitter.onComplete();
        });

        loginNavigation(observable);
    }

    private void loginNavigation(Observable<User> observable) {
        Disposable subscriptionUser = observable.filter(u -> u.getRole().getAuthority().equals(Constants.USER))
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(u -> mView.navigateToStep1(u), error -> mView.showError(error));

//        Disposable subscriptionAdmin = observable.filter(u -> u.getRole().getAuthority().equals(Constants.ADMIN))
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(u -> mView.navigateToRequests(u), error -> mView.showError(error));
    }
}

