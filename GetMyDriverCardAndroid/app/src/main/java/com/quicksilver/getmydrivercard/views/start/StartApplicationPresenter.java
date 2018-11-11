package com.quicksilver.getmydrivercard.views.start;

import com.quicksilver.getmydrivercard.async.base.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class StartApplicationPresenter implements StartApplicationContracts.Presenter {
    private static final int DELAY_TIME = 2000;
    private StartApplicationContracts.View mView;

    private SchedulerProvider mSchedulerProvider;

    @Inject
    public StartApplicationPresenter(SchedulerProvider schedulerProvider) {
        this.mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(StartApplicationContracts.View view) {
        mView = view;
    }

    @Override
    public void load() {
        Disposable disposable = Observable.create((ObservableOnSubscribe<StartApplicationContracts.View>) emitter -> {
            emitter.onNext(mView);
            emitter.onComplete();
        })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnNext(StartApplicationContracts.View::showLoading)
                .delay(DELAY_TIME, TimeUnit.MILLISECONDS)
                .doOnSubscribe(v -> mView.hideLoading())
                .subscribe(v -> mView.navigateToHome(), error -> mView.showError(error));
    }
}
