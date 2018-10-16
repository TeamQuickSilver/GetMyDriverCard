package com.quicksilver.getmydrivercard.views.step1;

import javax.inject.Inject;

public class Step1Presenter implements Step1Contracts.Presenter {
    private Step1Contracts.View mView;

    @Inject
    public Step1Presenter() {

    }

    @Override
    public void subscribe(Step1Contracts.View view) {
        mView = view;
    }
}
