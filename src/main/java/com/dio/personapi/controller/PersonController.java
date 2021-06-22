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

        return createResponseMessage(savedPerson.getCpf(), "Created person with CPF ");
    }

    @PutMapping("/{id}")
    public ResponseMessageDTO updatePersonById(
            @PathVariable Long id,
            @RequestBody @Valid PersonDTO personDTO
    ) throws PersonNotFoundException {
        var updatedPerson = personService.updatePersonById(id, personDTO);

        return createResponseMessage(updatedPerson.getCpf(), "Updated person with CPF ");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable Long id) throws PersonNotFoundException {
        personService.deletePersonById(id);
    }

    private ResponseMessageDTO createResponseMessage(String cpf, String message) {
        return ResponseMessageDTO
                .builder()
                .message(message + cpf)
                .build();
    }
}
