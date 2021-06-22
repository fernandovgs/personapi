package com.dio.personapi.domain.mappers;

import com.dio.personapi.domain.dtos.PersonDTO;
import com.dio.personapi.domain.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);
    PersonDTO toDTO(Person person);
}
