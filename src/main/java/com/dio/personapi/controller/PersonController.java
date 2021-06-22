package com.dio.personapi.controller;

import com.dio.personapi.exceptions.PersonNotFoundException;
import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.dtos.ResponseMessageDTO;
import com.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
