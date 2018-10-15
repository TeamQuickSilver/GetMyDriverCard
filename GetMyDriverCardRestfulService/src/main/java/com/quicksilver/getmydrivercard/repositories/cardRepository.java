package com.quicksilver.getmydrivercard.repositories;


import com.quicksilver.getmydrivercard.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Person, Long> {



}
