package com.dio.personapi.controller;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.dtos.ResponseMessageDTO;
import com.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    // testing purposes
    @GetMapping
    public List<PersonDTO> getBook() {
        return personService.findAllPersons();
    }

    @PostMapping
    public ResponseMessageDTO createPerson(@RequestBody PersonDTO personDTO) {
        var savedPerson = personService.createPerson(personDTO);

        return ResponseMessageDTO
                .builder()
                .message("Created person with CPF " + savedPerson.getCpf())
                .build();
    }
}
