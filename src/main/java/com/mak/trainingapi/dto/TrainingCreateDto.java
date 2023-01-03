package com.mak.trainingapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public record TrainingCreateDto(
        @NotNull Timestamp startDateTime,
        @NotNull Timestamp endDateTime,
        @NotNull Long duration,
        @NotNull Double distance,
        @NotNull String additionalInfo,
        @NotNull String username
) {

    public String getUsername(){
        return username;
    }
}
