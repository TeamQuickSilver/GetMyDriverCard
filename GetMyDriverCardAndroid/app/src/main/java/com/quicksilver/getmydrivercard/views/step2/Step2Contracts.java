package com.quicksilver.getmydrivercard.views.step2;

import com.quicksilver.getmydrivercard.models.Application;

public interface Step2Contracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);
    }

    interface Navigator {
        void navigateToNextStep(Application application);
    }
}
