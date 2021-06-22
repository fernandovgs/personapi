package com.dio.personapi.controller;

import com.dio.personapi.exceptions.PersonNotFoundException;
import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.dtos.ResponseMessageDTO;
import com.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    // testing purposes
    @GetMapping
    public List<PersonDTO> getPerson() {
        return personService.findAllPersons();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessageDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        var savedPerson = personService.createPerson(personDTO);

        return ResponseMessageDTO
                .builder()
                .message("Created person with CPF " + savedPerson.getCpf())
                .build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deletePersonById(id);
    }
}
