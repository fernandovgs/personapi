package com.dio.personapi.domain.repositories;

import com.dio.personapi.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
