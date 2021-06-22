package com.dio.personapi.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    @NotNull
    @Size(min = 1, max = 200)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 200)
    private String lastName;

    @NotNull
    private String cpf;

    private LocalDate birthDate;

    private List<PhoneDTO> phones;

}
