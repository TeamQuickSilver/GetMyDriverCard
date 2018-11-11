package com.quicksilver.getmydrivercard.views.step2;

import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.services.ApplicationService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class Step2Presenter implements Step2Contracts.Presenter {
    private final ApplicationService mApplicationService;
    private final SchedulerProvider mSchedulerProvider;
    private Step2Contracts.View mView;

    @Inject
    public Step2Presenter(ApplicationService applicationService, SchedulerProvider mSchedulerProvider) {
        this.mApplicationService = applicationService;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void subscribe(Step2Contracts.View view) {
        mView = view;
    }

    @Override
    public void loadApplication(Long id) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Application>) emitter -> {
            List<Application> applications = mApplicationService.getById(id);
            Application lastApplication = applications.get(applications.size() - 1);
            emitter.onNext(lastApplication);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(a -> mView.getApplication(a), error -> error.printStackTrace());
    }
}
