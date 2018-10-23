package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<Application> getAllByUserOrderById(User user) {
        return applicationRepository.findAllByUserOrderByApplicationId(user);
    }

    @Override
    public List<Application> getAllByStatus(ApplicationStatus status) {
        return applicationRepository.findAllByStatus(status);
    }

    @Override
    public List<Application> getAllOrderById() {
        return applicationRepository.findAllByOrderByApplicationId();
    }

    @Override
    public List<Application> getAllOrderByDateOfSubmission() {
        return applicationRepository.findAllByOrderByDateOfSubmission();
    }

    @Override
    public List<Application> getAllOrderByPersonName() {
        return applicationRepository.findAllByPersonIdentityCard_firstNameAndPersonIdentityCard_fathersNameAndPersonIdentityCard_lastName();
    }

    @Override
    public Application getById(Long id) {
        return applicationRepository.getByApplicationId(id);
    }
}
