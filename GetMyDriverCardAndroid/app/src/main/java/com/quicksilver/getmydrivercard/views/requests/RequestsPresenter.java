package com.quicksilver.getmydrivercard.views.requests;

import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;
import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;
import com.quicksilver.getmydrivercard.services.ApplicationService;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class RequestsPresenter implements RequestsContracts.Presenter {
    private RequestsContracts.View mView;
    private final ApplicationService mApplicationService;
    private final SchedulerProvider mSchedulerProvider;

    @Inject
    public RequestsPresenter(ApplicationService applicationService, SchedulerProvider schedulerProvider) {
        this.mApplicationService = applicationService;
        this.mSchedulerProvider = schedulerProvider;
    }


    @Override
    public void subscribe(RequestsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadApplicationsByStatus(ApplicationStatus status) {
        Observable<List<Application>> observable = Observable.create(emitter -> {
            List<Application> applications = mApplicationService.getAllByStatus(status);
            emitter.onNext(applications);
            emitter.onComplete();
        });

        dispose(observable);
    }

    @Override
    public void loadApplicationsByDate(Date date) {
        Observable<List<Application>> observable = Observable.create(emitter -> {
            List<Application> applications = mApplicationService.getAllByDateOfSubmission(date);
            emitter.onNext(applications);
            emitter.onComplete();
        });

        dispose(observable);
    }

    @Override
    public void loadApplicationsByName(String name) {
        Observable<List<Application>> observable = Observable.create(emitter -> {
            List<Application> applications = mApplicationService.getAllByPersonName(name);
            emitter.onNext(applications);
            emitter.onComplete();
        });

        dispose(observable);
    }

    @Override
    public void loadApplicationsById(Long id) {
        Observable<List<Application>> observable = Observable.create(emitter -> {
            List<Application> applications = mApplicationService.getById(id);
            emitter.onNext(applications);
            emitter.onComplete();
        });

        dispose(observable);
    }

    private void dispose(Observable<List<Application>> observable) {
        Disposable disposable = observable.subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(a -> mView.loadApplications(a), error -> mView.showError(error));
    }
}
