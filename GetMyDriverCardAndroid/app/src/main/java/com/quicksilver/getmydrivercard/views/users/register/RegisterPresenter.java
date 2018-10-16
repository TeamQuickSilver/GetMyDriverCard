package com.quicksilver.getmydrivercard.views.users.register;


import com.quicksilver.getmydrivercard.models.User;

import javax.inject.Inject;


public class RegisterPresenter implements RegisterContracts.Presenter {


    private RegisterContracts.View mView;

    @Inject
    public RegisterPresenter() {

    }

    @Override
    public void subscribe(RegisterContracts.View view) {
        mView = view;
    }

    @Override
    public void register(User user) {

    }
}
