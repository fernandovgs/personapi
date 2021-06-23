package com.dio.personapi.mapper;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.dtos.PhoneDTO;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.domain.entities.Phone;
import com.dio.personapi.domain.mappers.PersonMapper;
import com.dio.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonMapperTest {

    @Autowired
    private static final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createPersonDTO();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getFirstName(), person.getFirstName());
        assertEquals(personDTO.getLastName(), person.getLastName());
        assertEquals(personDTO.getCpf(), person.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phoneDTO.getPhoneType(), phone.getPhoneType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Person person = PersonUtils.createPersonEntity();
        PersonDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getFirstName(), personDTO.getFirstName());
        assertEquals(person.getLastName(), personDTO.getLastName());
        assertEquals(person.getCpf(), personDTO.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phone.getPhoneType(), phoneDTO.getPhoneType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }
}