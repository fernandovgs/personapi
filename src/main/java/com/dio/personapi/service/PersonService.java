package com.dio.personapi.service;

import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.exceptions.PersonNotFoundException;
import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.mappers.PersonMapper;
import com.dio.personapi.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PersonDTO> findAllPersons() {
        var persons = personRepository.findAll();

        return persons.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findPersonById(Long id) throws PersonNotFoundException {
        var foundPerson = verifyIfExists(id);

        return personMapper.toDTO(foundPerson);
    }

    public void deletePersonById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
