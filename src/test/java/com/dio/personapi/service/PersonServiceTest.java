package com.dio.personapi.service;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.domain.mappers.PersonMapper;
import com.dio.personapi.domain.repositories.PersonRepository;
import com.dio.personapi.exceptions.PersonNotFoundException;
import com.dio.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private static final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    void givenPersonDTOThenReturnSavedPersonDTO() {
        PersonDTO expectedPersonDTOToSave = PersonUtils.createPersonDTO();
        Person expectedSavedPerson = PersonUtils.createPersonEntity();

        when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        var savedPersonDTO = personService.createPerson(expectedPersonDTOToSave);

        assertEquals(savedPersonDTO, expectedPersonDTOToSave);
    }

    @Test
    void givenASingletonListOfPersonsThenReturnList() {
        List<PersonDTO> expectedPersonDTOList = Collections.singletonList(PersonUtils.createPersonDTO());
        List<Person> expectedPersonList = Collections.singletonList(PersonUtils.createPersonEntity());

        when(personRepository.findAll()).thenReturn(expectedPersonList);

        var returnedPersonDTOList = personService.findAllPersons();

        assertEquals(expectedPersonDTOList, returnedPersonDTOList);
    }

    @Test
    void whenExclusionIsCalledWithValidPersonIdThenAPersonShouldBeDeleted() throws PersonNotFoundException {
        PersonDTO expectedPersonDTO = PersonUtils.createPersonDTO();
        Person expectedPerson = PersonUtils.createPersonEntity();

        when(personRepository.findById(1L)).thenReturn(Optional.of(expectedPerson));

        var returnedExpectedPersonDTO = personService.findPersonById(1L);

        assertEquals(expectedPersonDTO, returnedExpectedPersonDTO);
    }

    @Test
    void givenFindPersonWithInvalidIdThenAnExceptionShouldBeThrown() {
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> personService.findPersonById(1L));
    }

    @Test
    void givenAPersonIdThenDeletePerson() throws PersonNotFoundException {
        Person expectedDeletedPerson = PersonUtils.createPersonEntity();

        when(personRepository.findById(expectedDeletedPerson.getId()))
                .thenReturn(Optional.of(expectedDeletedPerson));
        doNothing().when(personRepository).deleteById(expectedDeletedPerson.getId());

        personService.deletePersonById(expectedDeletedPerson.getId());

        verify(personRepository, times(1)).findById(expectedDeletedPerson.getId());
        verify(personRepository, times(1)).deleteById(expectedDeletedPerson.getId());
    }

    @Test
    void givenDeletePersonWithInvalidIdThenAnExceptionShouldBeThrown() {
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> personService.deletePersonById(1L));
    }

    @Test
    void givenUpdateValidPersonThenReturnAValidUpdatedPerson() throws PersonNotFoundException {
        PersonDTO expectedPersonDTOUpdated = PersonUtils.createUpdatedPersonDTO();
        Person expectedPersonToUpdate = PersonUtils.createPersonEntity();
        Person expectedPersonUpdated = PersonUtils.createUpdatedPersonEntity();

        when(personRepository.findById(expectedPersonToUpdate.getId()))
                .thenReturn(Optional.of(expectedPersonToUpdate));
        when(personRepository.save(expectedPersonUpdated)).thenReturn(expectedPersonUpdated);

        var returnedPersonDTOUpdated = personService
                .updatePersonById(expectedPersonToUpdate.getId(), expectedPersonDTOUpdated);

        assertEquals(expectedPersonDTOUpdated, returnedPersonDTOUpdated);
    }

    @Test
    void whenUpdatePersonWithInvalidPersonIdThenAnExceptionShouldBeThrown() {
        PersonDTO wrongPersonDTOToUpdate = PersonUtils.createWrongPersonDTO();

        when(personRepository.findById(wrongPersonDTOToUpdate.getId())).thenReturn(Optional.empty());

        assertThrows(
                PersonNotFoundException.class,
                () -> personService.updatePersonById(wrongPersonDTOToUpdate.getId(), wrongPersonDTOToUpdate)
        );
    }
}
