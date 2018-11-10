package com.quicksilver.getmydrivercard.views.preview;

import com.quicksilver.getmydrivercard.models.Application;

import javax.inject.Inject;

public class PreviewPresenter implements PreviewContracts.Presenter {
    private PreviewContracts.View mView;

    @Inject
    public PreviewPresenter() {

    }

    @Override
    public void subscribe(PreviewContracts.View view) {
        mView = view;
    }

    @Override
    public void submit(Application application) {

    }
}
