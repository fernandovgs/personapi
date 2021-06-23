package com.dio.personapi.utils;

import com.dio.personapi.domain.dtos.PhoneDTO;
import com.dio.personapi.domain.entities.Phone;
import com.dio.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final Long ID = 1L;
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final String NUMBER = "11999999999";

    public static PhoneDTO createPhoneDTO() {
        return PhoneDTO.builder().id(ID).phoneType(PHONE_TYPE).number(NUMBER).build();
    }

    public static Phone createPhoneEntity() {
        return Phone.builder().id(ID).phoneType(PHONE_TYPE).number(NUMBER).build();
    }


}
