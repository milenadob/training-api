package com.mak.trainingapi.dto;

import java.sql.Timestamp;

public interface TrainingProjection {
    Timestamp getStartDateTime();

    Timestamp getEndDateTime();

    Long getDuration();

    Double getDistance();

    String getAdditionalInfo();
}
