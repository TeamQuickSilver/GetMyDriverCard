package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;

import java.util.Date;
import java.util.List;

public interface ApplicationService {

    List<Application> getAllByUserEmail(String email);

    List<Application> getByIdentityNumber(Long id);

    Application save(Application application);
}
