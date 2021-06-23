package com.dio.personapi.service;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.domain.mappers.PersonMapper;
import com.dio.personapi.domain.repositories.PersonRepository;
import com.dio.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private static final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    void givenPersonDTOThenReturnSavedMessage() {
        PersonDTO expectedPersonDTOToSave = PersonUtils.createPersonDTO();
        Person expectedSavedPerson = PersonUtils.createPersonEntity();

        when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        var savedPersonDTO = personService.createPerson(expectedPersonDTOToSave);
        var savedPerson = personMapper.toModel(savedPersonDTO);

        Assertions.assertEquals(savedPersonDTO, expectedPersonDTOToSave);
        Assertions.assertEquals(expectedSavedPerson, savedPerson);
    }
}
