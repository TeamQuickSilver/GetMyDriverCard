package com.quicksilver.getmydrivercard.views.requests;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;

import java.util.Date;
import java.util.List;

public interface RequestsContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void setNavigator(Navigator navigator);

        void loadApplications(List<Application> applications);

        void showError(Throwable error);
    }

    interface Presenter {
        void subscribe(View view);

        void loadApplicationsByStatus(ApplicationStatus status);

        void loadApplicationsByDate(Date date);

        void loadApplicationsByName(String name);

        void loadApplicationsById(Long id);
    }

    interface Navigator {

        void navigateToDetails(Application application);
    }
}
