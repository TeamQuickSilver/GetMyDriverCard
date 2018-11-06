package com.quicksilver.getmydrivercard.views.preview;

public interface PreviewContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);
    }

    interface Presenter {
        void subscribe(View view);
    }

    interface Navigator {

        void navigateTo(String reason);
    }
}
