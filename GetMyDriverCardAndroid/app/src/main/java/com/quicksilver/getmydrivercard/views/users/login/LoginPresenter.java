package com.quicksilver.getmydrivercard.views.users.login;

public class LoginPresenter implements LoginContracts.Presenter {
    private LoginContracts.View mView;

    @Override
    public void subscribe(LoginContracts.View view) {
        mView = view;
    }
}
