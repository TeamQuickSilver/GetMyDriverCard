package com.quicksilver.getmydrivercard.views.step3;

import android.os.Bundle;

import com.quicksilver.getmydrivercard.models.Application;

public interface Step3Contracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void onRestoreInstanceState(Bundle savedInstanceState);
    }

    interface Presenter {
        void subscribe(Step3Contracts.View view);
    }

    interface Navigator {
        void navigateToNextStep(Application application, byte[] imageBytes);
    }
}
