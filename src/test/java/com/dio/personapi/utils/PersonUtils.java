package com.dio.personapi.utils;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.dtos.PhoneDTO;
import com.dio.personapi.domain.entities.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class PersonUtils {

    private static final Long ID = 1L;
    private static final String FIRST_NAME = "Fernando";
    private static final String LAST_NAME = "Gianini";
    private static final String CPF = "670.063.320-60";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1990, 1, 1);

    public static PersonDTO createPersonDTO() {
        return PersonDTO.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate("01-01-1990")
                .phones(Collections.singletonList(PhoneUtils.createPhoneDTO()))
                .build();
    }

    public static Person createPersonEntity() {
        return Person.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createPhoneEntity()))
                .build();
    }
}
