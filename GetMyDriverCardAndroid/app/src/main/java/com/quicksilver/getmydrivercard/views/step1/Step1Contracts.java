package com.quicksilver.getmydrivercard.views.step1;

import com.quicksilver.getmydrivercard.models.User;

public interface Step1Contracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);
    }

    interface Navigator {

        void navigateToStep2(String reason, User user);
    }
}
