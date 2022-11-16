package com.mak.trainingapi.mapper;

import com.mak.trainingapi.dto.TrainingViewDto;
import com.mak.trainingapi.model.Training;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface TrainingViewMapper {

    TrainingViewMapper INSTANCE = Mappers.getMapper(TrainingViewMapper.class);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    TrainingViewDto trainingToTrainingViewDto(Training training);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    ArrayList<TrainingViewDto> toTrainingViewList(ArrayList<Training> trainingArrayList);
}
