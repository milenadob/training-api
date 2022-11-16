package com.mak.trainingapi.dto;

import java.time.LocalDate;

public record UserUpdateDto(
        String sex,
        Double weight,
        Double height,
        LocalDate birthday
) {
}
