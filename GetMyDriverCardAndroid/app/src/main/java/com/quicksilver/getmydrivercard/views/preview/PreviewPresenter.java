package com.quicksilver.getmydrivercard.views.preview;

import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.services.ApplicationService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class PreviewPresenter implements PreviewContracts.Presenter {
    private final ApplicationService mApplicationsService;
    private final SchedulerProvider mSchedulerProvider;
    private PreviewContracts.View mView;

    @Inject
    public PreviewPresenter(ApplicationService applicationService, SchedulerProvider schedulerProvider) {
        this.mApplicationsService = applicationService;
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(PreviewContracts.View view) {
        mView = view;
    }

    @Override
    public void submit(Application applicationDetails) {
        Disposable disposable = Observable.create((ObservableOnSubscribe<Application>) emitter -> {
            Application application = mApplicationsService.create(applicationDetails);
            emitter.onNext(application);
            emitter.onComplete();
        }).subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(v -> mView.showSuccessfulToast(), error -> mView.showError(error));
    }
}
