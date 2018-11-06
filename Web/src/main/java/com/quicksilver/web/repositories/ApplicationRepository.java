package com.quicksilver.web.repositories;

import com.quicksilver.web.models.Application;
import com.quicksilver.web.models.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findAllByUserEmailOrderByApplicationId(String email);

    List<Application> findAllByDateOfSubmission(Date date);

    List<Application> findAllByOrderByPersonIdentityCardFirstNameAscPersonIdentityCardFathersNameAscPersonIdentityCardLastNameAsc();

    List<Application> findAllByStatus(ApplicationStatus status);

    List<Application> getByPersonIdentityCardPersonalNumber(Long id);

    Application getByApplicationId(Long id);

}
