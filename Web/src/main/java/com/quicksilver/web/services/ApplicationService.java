package com.quicksilver.web.services;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Date;
import java.util.List;

//@PreAuthorize("hasRole('ADMIN')")
public interface ApplicationService {

    List<Application> getAllByUserEmailOrderById(String email);

    List<Application> getAllByStatus(ApplicationStatus status);

    List<Application> getAllOrderByDateOfSubmission(Date date);

    List<Application> getAllOrderByPersonName();

    List<Application> getByIdentityNumber(Long id);

    Application getById(Long id);

    Application save(Application application);

}
