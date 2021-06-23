package com.dio.personapi.utils;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.entities.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final Long ID = 1L;
    private static final Long WRONG_ID = 2L;
    private static final String FIRST_NAME = "Fernando";
    private static final String UPDATED_FIRST_NAME = "Forty Two";
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

    public static PersonDTO createUpdatedPersonDTO() {
        return PersonDTO.builder()
                .id(ID)
                .firstName(UPDATED_FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate("01-01-1990")
                .phones(Collections.singletonList(PhoneUtils.createPhoneDTO()))
                .build();
    }

    public static PersonDTO createWrongPersonDTO() {
        return PersonDTO.builder()
                .id(WRONG_ID)
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

    public static Person createWrongPersonEntity() {
        return Person.builder()
                .id(WRONG_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createPhoneEntity()))
                .build();
    }

    public static Person createUpdatedPersonEntity() {
        return Person.builder()
                .id(ID)
                .firstName(UPDATED_FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createPhoneEntity()))
                .build();
    }
}
