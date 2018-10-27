package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ApplicationService {
    List<Application> getAllByUserEmailOrderById(String email) throws IOException;

    List<Application> getAllByStatus(ApplicationStatus status) throws IOException;

    List<Application> getAllByDateOfSubmission(Date date) throws IOException;

    List<Application> getAllByPersonName(String name) throws IOException;

    List<Application> getById(Long id) throws IOException;

    Application create(Application application) throws IOException;
}
