package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;

import java.util.List;

public interface ApplicationService {

    List<Application> getAllByUserOrderById(User user);

    List<Application> getAllByStatus(ApplicationStatus status);

    Application getById(Long id);

}
