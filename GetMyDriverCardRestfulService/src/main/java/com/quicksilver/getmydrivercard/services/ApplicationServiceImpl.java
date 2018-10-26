package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<Application> getAllByUserEmailOrderById(String email) {
        return applicationRepository.findAllByUserEmailOrderByApplicationId(email);
    }

    @Override
    public List<Application> getAllByStatus(ApplicationStatus status) {
        return applicationRepository.findAllByStatus(status);
    }

    @Override
    public List<Application> getAllOrderByDateOfSubmission(Date date) {
        return applicationRepository.findAllByDateOfSubmission(date);
    }

    @Override
    public List<Application> getAllOrderByPersonName() {
        return applicationRepository.findAllByOrderByPersonIdentityCardFirstNameAscPersonIdentityCardFathersNameAscPersonIdentityCardLastNameAsc();
    }

    @Override
    public Application getById(Long id) {
        return applicationRepository.getByApplicationId(id);
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }
}
