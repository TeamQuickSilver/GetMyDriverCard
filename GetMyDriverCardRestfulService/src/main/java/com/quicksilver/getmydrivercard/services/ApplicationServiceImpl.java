package com.quicksilver.getmydrivercard.services;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.repositories.ApplicationRepository;
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
    public List<Application> getAllByUserEmail(String email) {
        return applicationRepository.findAllByUserEmail(email);
    }

    @Override
    public List<Application> getByIdentityNumber(Long id) {
        return applicationRepository.findAllByPersonIdentityCardPersonalNumber(id);
    }

    @Override
    public Application save(Application application) {
        Application debug = application;
        return applicationRepository.save(application);
    }
}
