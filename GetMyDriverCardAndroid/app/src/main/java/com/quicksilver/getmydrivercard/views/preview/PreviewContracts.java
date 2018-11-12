package com.quicksilver.getmydrivercard.views.preview;

import com.quicksilver.getmydrivercard.models.Application;

public interface PreviewContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void showSuccessfulToast();

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void submit(Application application);
    }

    interface Navigator {

        void navigateTo(Application application);
    }
}
