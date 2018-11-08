package com.quicksilver.getmydrivercard.views.step3;

import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.services.ApplicationService;

import javax.inject.Inject;

public class Step3Presenter implements Step3Contracts.Presenter{
    private final ApplicationService mApplicationService;
    private final SchedulerProvider mSchedulerProvider;

    private Step3Contracts.View mView;

    @Inject
    public Step3Presenter(ApplicationService mApplicationService, SchedulerProvider mSchedulerProvider) {
        this.mApplicationService = mApplicationService;

        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(Step3Contracts.View view) {
        mView = view;
    }
}
