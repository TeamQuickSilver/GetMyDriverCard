package com.quicksilver.getmydrivercard.views.step4;

public interface Step4Contracts {

    interface View {
        void setPresenter(Step4Contracts.Presenter presenter);

        void setNavigator(Step4Contracts.Navigator navigator);
    }

    interface Presenter {
        void subscribe(Step4Contracts.View view);
    }

    interface Navigator {

    }
}
