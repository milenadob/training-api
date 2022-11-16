package com.mak.trainingapi.dto;

import java.sql.Timestamp;

public record TrainingViewDto (
        Timestamp startDateTime,
        Timestamp endDateTime,
        Long duration,
        Double distance,
        String additionalInfo
){
}
