package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;

import java.util.Date;
import java.util.List;

public interface ApplicationService {
    List<Application> getAllByUserEmailOrderById(String email);

    List<Application> getAllByStatus(ApplicationStatus status);

    List<Application> getAllOrderByDateOfSubmission(Date date);

    List<Application> getAllOrderByPersonName();

    Application getById(Long id);

    Application create(Application application);
}
