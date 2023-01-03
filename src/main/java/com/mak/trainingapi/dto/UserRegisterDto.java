package com.mak.trainingapi.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record UserRegisterDto(
        @NotNull String username,
        @NotNull String password,
        @NotNull String sex,
        @NotNull Double weight,
        @NotNull Double height,
        @NotNull LocalDate birthday
        ) {
}
