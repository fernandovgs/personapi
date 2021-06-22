package com.dio.personapi.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class ResponseMessageDTO {

    @NotNull
    private String message;
}
