package com.quicksilver.getmydrivercard.views.users.home;

public interface HomeContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);
    }

    interface Navigator {

        void navigateToLogin();

        void navigateToRegister();
    }
}
