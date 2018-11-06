package com.quicksilver.getmydrivercard.views.step3;

import com.quicksilver.getmydrivercard.models.Application;

public interface Step3Contracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(Step3Contracts.View view);
    }

    interface Navigator {
        void navigateToNextStep(Application application);
    }
}
