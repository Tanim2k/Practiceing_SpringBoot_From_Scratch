package com.ibrahim.springboot.dtoimp;

import com.ibrahim.springboot.dto.UserDto;
import com.ibrahim.springboot.entity.User;

public class UserMapper {

    public static User userDtoToUser(UserDto userDto)
    {
        User user=new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
    public static UserDto userToUserDto(User user)
    {
        UserDto userDto=new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return  userDto;
    }
}
