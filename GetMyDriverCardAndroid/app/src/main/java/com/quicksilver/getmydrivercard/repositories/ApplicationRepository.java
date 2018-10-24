package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;
import com.quicksilver.getmydrivercard.models.User;

import java.io.IOException;
import java.util.List;

public interface ApplicationRepository {
    List<Application> getAllByUserOrderById(User user) throws IOException;

    List<Application> getAllByStatus(ApplicationStatus status) throws IOException;

    List<Application> getAllOrderById() throws IOException;

    List<Application> getAllOrderByDateOfSubmission() throws IOException;

    List<Application> getAllOrderByPersonName() throws IOException;

    Application getById(Long id) throws IOException;

    Application save(Application application) throws IOException;
}
