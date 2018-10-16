package com.quicksilver.getmydrivercard.views.users.login;

import javax.inject.Inject;

public class LoginPresenter implements LoginContracts.Presenter {
    private LoginContracts.View mView;

    @Inject
    public LoginPresenter() {

    }

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }
}
