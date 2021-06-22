package com.dio.personapi.domain.mappers;

import com.dio.personapi.domain.dtos.PhoneDTO;
import com.dio.personapi.domain.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toModel(PhoneDTO phoneDTO);
    PhoneDTO toDTO(Phone phone);

}
