package com.ibrahim.springboot.dtoimp;

import com.ibrahim.springboot.dto.UserDto;
import com.ibrahim.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
 //   @Mapping(source = "email",target = "emailAddress")

    AutoUserMapper Mapper= Mappers.getMapper(AutoUserMapper.class);
    UserDto userToDto(User user);
    User dtoToUser(UserDto userDto);
}
