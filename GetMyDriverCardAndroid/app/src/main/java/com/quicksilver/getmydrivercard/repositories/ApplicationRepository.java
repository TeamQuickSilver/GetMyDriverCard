package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;
import com.quicksilver.getmydrivercard.models.User;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ApplicationRepository {
    List<Application> getAllByUserOrderById(User user) throws IOException;

    List<Application> getAllByStatus(ApplicationStatus status) throws IOException;

    List<Application> getAllByDateOfSubmission(Date date) throws IOException;

    List<Application> getAllByPersonName() throws IOException;

    Application getById(Long id) throws IOException;

    Application create(Application application) throws IOException;
}
