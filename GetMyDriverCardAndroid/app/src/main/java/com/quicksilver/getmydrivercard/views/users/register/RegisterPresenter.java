package com.quicksilver.getmydrivercard.views.users.register;

import com.quicksilver.getmydrivercard.models.User;

public class RegisterPresenter implements RegisterContracts.Presenter {

    private RegisterContracts.View mView;

    @Override
    public void subscribe(RegisterContracts.View view) {
        mView = view;
    }

    @Override
    public void register(User user) {

    }
}
