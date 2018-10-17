package com.quicksilver.getmydrivercard.views.users.register;

import com.quicksilver.getmydrivercard.models.User;
import com.quicksilver.getmydrivercard.views.users.login.LoginContracts;

public interface RegisterContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable error);

        void setNavigator(RegisterContracts.Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);

        void register(User user);
    }

    interface Navigator {
        void navigate();
    }
}