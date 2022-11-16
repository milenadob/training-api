package com.mak.trainingapi.dto;

import java.time.LocalDate;

public record UserViewDto (
        String username,
        String sex,
        String weight,
        String height,
        LocalDate birthday
) {
}
