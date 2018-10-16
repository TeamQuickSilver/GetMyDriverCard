package com.quicksilver.getmydrivercard.repositories;

import com.quicksilver.getmydrivercard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository  extends JpaRepository<User, Long> {

}
