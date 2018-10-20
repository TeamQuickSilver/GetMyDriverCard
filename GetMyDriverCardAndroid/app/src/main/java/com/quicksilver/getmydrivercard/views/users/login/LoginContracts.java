package com.quicksilver.getmydrivercard.views.users.login;

import com.quicksilver.getmydrivercard.models.User;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void navigateToStep1();

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void login(boolean isFacebookLoginSucceeded);

        void login(User user);
    }

    interface Navigator {

        void navigateToStep1();

        void navigateToRegister();
    }
}
