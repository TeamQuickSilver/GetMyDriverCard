package com.quicksilver.getmydrivercard.views.users.home;

import javax.inject.Inject;

public class HomePresenter implements HomeContracts.Presenter {
    private HomeContracts.View mView;

    @Inject
    public HomePresenter() {

    }

    @Override
    public void subscribe(HomeContracts.View view) {
        mView = view;
    }
}
