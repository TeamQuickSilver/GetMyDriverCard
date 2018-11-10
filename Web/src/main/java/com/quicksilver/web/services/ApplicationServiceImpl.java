package com.quicksilver.web.services;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import com.quicksilver.web.repositories.ApplicationRepository;
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
    public List<Application> getAllByEmail(String email) {
        return applicationRepository.findAllByUserEmail(email);
    }

    @Override
    public List<Application> getAllByStatus(ApplicationStatus status) {
        return applicationRepository.findAllByStatus(status);
    }

    @Override
    public List<Application> getAllByDateOfSubmissions(Date date) {
        return applicationRepository.findAllByDateOfSubmission(date);
    }

    @Override
    public List<Application> getAllByPersonNames(String name) {
        return applicationRepository
                .findAllByPersonIdentityCardFirstNameOrPersonIdentityCardFathersNameOrPersonIdentityCardLastName(name, name, name);
    }

    @Override
    public List<Application> getByIdentityNumber(Long id) {
        return applicationRepository.findAllByPersonIdentityCardPersonalNumber(id);
    }

    @Override
    public Application getById(Long id) {
        return applicationRepository.findByApplicationId(id);
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }
}
