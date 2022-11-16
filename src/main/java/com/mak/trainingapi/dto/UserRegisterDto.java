package com.mak.trainingapi.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserRegisterDto(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String sex,
        @NotNull Double weight,
        @NotNull Double height,
        @NotNull LocalDate birthday
        ) {
}
