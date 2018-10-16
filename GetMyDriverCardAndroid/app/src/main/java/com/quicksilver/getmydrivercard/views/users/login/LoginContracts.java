package com.quicksilver.getmydrivercard.views.users.login;

public interface LoginContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);
    }

    interface Navigator {

    }
}
