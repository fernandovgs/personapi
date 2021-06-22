package com.dio.personapi.domain.repository;

import com.dio.personapi.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
