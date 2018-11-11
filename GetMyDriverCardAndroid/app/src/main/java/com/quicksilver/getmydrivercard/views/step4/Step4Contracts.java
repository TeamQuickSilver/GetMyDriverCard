package com.quicksilver.getmydrivercard.views.step4;

import com.quicksilver.getmydrivercard.models.Application;

import java.io.IOException;
import java.io.InputStream;

public interface Step4Contracts {

    interface View {
        void setPresenter(Step4Contracts.Presenter presenter);

        void setNavigator(Step4Contracts.Navigator navigator);

        void showError(Throwable error);

        void navigateToRequests();
    }

    interface Presenter {
        void subscribe(Step4Contracts.View view);

        byte[] convertUriIntoByteArray(InputStream inputStream) throws IOException;

        void saveApplication(Application applicationDetails);
    }

    interface Navigator {

        void navigateToRequests(Application application);
    }
}
