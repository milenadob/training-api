package com.mak.trainingapi.dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public record TrainingViewDto (
        @NotNull Timestamp startDateTime,
        @NotNull Timestamp endDateTime,
        @NotNull Long duration,
        @NotNull Double distance,
        @NotNull String additionalInfo
){
}
