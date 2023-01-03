package com.mak.trainingapi.mapper;

import com.mak.trainingapi.dto.UserRegisterDto;
import com.mak.trainingapi.dto.UserUpdateDto;
import com.mak.trainingapi.model.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userRegisterDtoToUser(UserRegisterDto request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    void userUpdateDtoToUser(UserUpdateDto request, @MappingTarget User user);

}
