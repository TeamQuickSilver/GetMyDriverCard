package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;

import java.util.Date;
import java.util.List;

public interface ApplicationService {

    List<Application> getAllByUserEmailOrderById(String email);

    List<Application> getAllByStatus(ApplicationStatus status);

    List<Application> getAllOrderByDateOfSubmission(Date date);

    List<Application> getAllOrderByPersonName();

    List<Application> getById(Long id);

    Application save(Application application);
}
