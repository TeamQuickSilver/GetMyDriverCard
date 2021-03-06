package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findAllByUserEmail(String email);

    List<Application> findAllByPersonIdentityCardPersonalNumber(Long id);
}
