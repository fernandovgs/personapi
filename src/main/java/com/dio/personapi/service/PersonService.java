package com.dio.personapi.service;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.mappers.PersonMapper;
import com.dio.personapi.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private static final PersonMapper personMapper = PersonMapper.INSTANCE;

    private final PersonRepository personRepository;

    public PersonDTO createPerson(PersonDTO personDTO) {
        var person = personMapper.toModel(personDTO);
        var savedPerson = personRepository.save(person);
        return personMapper.toDTO(savedPerson);
    }
}
