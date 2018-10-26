package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import com.quicksilver.getmydrivercard.utils.ApplicationStatus;
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

    Application getByApplicationId(Long id);

}
