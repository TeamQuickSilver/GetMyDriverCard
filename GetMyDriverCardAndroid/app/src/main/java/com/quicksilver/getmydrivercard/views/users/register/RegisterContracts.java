package com.quicksilver.getmydrivercard.views.users.register;

import com.quicksilver.getmydrivercard.models.User;

public interface RegisterContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void navigateToStep1();

        void showError(Throwable error);

        void setNavigator(RegisterContracts.Navigator navigator);

        void showRegisterError();
    }

    interface Presenter {
        void subscribe(View view);

        void register(User user);
    }

    interface Navigator {
        void navigateToStep1();

        void navigateToLogin();
    }
}
