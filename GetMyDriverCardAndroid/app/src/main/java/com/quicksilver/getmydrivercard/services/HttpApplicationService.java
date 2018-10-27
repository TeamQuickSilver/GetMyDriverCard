package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.models.Application;
import com.quicksilver.getmydrivercard.models.ApplicationStatus;
import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class HttpApplicationService implements ApplicationService {
    private final ApplicationRepository mApplicationRepository;

    public HttpApplicationService(ApplicationRepository mApplicationRepository) {
        this.mApplicationRepository = mApplicationRepository;
    }

    @Override
    public List<Application> getAllByUserEmailOrderById(String email) throws IOException {
        return mApplicationRepository.getAllByUserEmailOrderById(email);
    }

    @Override
    public List<Application> getAllByStatus(ApplicationStatus status) throws IOException {
        return mApplicationRepository.getAllByStatus(status);
    }

    @Override
    public List<Application> getAllByDateOfSubmission(Date date) throws IOException {
        return mApplicationRepository.getAllByDateOfSubmission(date);
    }

    @Override
    public List<Application> getAllByPersonName(String name) throws IOException {
        return mApplicationRepository.getAllByPersonName(name);
    }

    @Override
    public List<Application> getById(Long id) throws IOException {
        return mApplicationRepository.getById(id);
    }

    @Override
    public Application create(Application application) throws IOException {
        return mApplicationRepository.create(application);
    }
}
