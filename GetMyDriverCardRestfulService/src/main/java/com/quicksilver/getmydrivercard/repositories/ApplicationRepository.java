package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.entities.Application;
import com.quicksilver.getmydrivercard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findAllByUserOrApplicationId(User user);
}
