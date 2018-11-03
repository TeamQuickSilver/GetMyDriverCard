package com.quicksilver.web.services;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;

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
