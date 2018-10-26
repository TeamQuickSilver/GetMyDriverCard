package com.quicksilver.getmydrivercard.views.users.login;

import com.quicksilver.getmydrivercard.models.User;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void navigateToStep1(User user);

        void showError(Throwable error);

        void navigateToRequests(User user);
    }

    interface Presenter {
        void subscribe(View view);

        void login(User user);

        void loginGoogleOrFacebookUser(User googleOrFacebookUser);
    }

    interface Navigator {

        void navigateToStep1(User user);

        void navigateToRegister();

        void navigateToRequests(User user);
    }
}
