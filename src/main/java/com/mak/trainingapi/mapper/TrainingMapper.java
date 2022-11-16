package com.mak.trainingapi.mapper;

import com.mak.trainingapi.dto.TrainingCreateDto;
import com.mak.trainingapi.dto.TrainingUpdateDto;
import com.mak.trainingapi.model.Training;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface TrainingMapper {

    TrainingMapper INSTANCE = Mappers.getMapper(TrainingMapper.class);

    Training trainingCreateDtoToTraining(TrainingCreateDto trainingCreateDto);

    @BeanMapping(nullValueCheckStrategy =  ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    void trainingUpdateDtoToTraining(TrainingUpdateDto trainingUpdateDto, @MappingTarget Training training);
}
