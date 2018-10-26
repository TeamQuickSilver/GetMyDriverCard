package com.quicksilver.getmydrivercard.views.requests;

public class RequestsPresenter implements RequestsContracts.Presenter {
    private RequestsContracts.View mView;


    @Override
    public void subscribe(RequestsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadNewApplications() {
//        Disposable disposable = Observable.create((ObservableOnSubscribe<User>) emitter -> {
////            User returnedUser = mUserService.register(user);
//            // Validator can be applied here
//            if (returnedUser == null) {
//                mView.showRegisterError();
//                return;
//            }
//            emitter.onNext(returnedUser);
//            emitter.onComplete();
//        }).subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(v -> mView.navigateToStep1(), error -> mView.showError(error));
    }
}
