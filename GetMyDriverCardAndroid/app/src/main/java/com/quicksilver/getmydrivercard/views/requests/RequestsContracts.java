package com.quicksilver.getmydrivercard.views.requests;

public interface RequestsContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);

        void loadNewApplications();
    }

    interface Navigator {

    }
}
