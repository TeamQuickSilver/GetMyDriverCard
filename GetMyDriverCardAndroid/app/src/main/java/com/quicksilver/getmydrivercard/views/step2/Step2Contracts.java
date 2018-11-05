package com.quicksilver.getmydrivercard.views.step2;

import com.quicksilver.getmydrivercard.models.Application;

public interface Step2Contracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void getApplication(Application application);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void loadApplication(Long id);
    }

    interface Navigator {
        void navigateToNextStep(Application application);
    }
}
