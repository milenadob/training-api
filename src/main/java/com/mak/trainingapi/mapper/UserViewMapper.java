package com.mak.trainingapi.mapper;

import com.mak.trainingapi.dto.UserViewDto;
import com.mak.trainingapi.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface UserViewMapper {

    UserViewMapper INSTANCE = Mappers.getMapper(UserViewMapper.class);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    UserViewDto userToUserView(User user);

}
