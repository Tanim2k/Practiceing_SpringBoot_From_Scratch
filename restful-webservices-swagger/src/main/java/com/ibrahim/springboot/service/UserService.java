package com.ibrahim.springboot.service;

import com.ibrahim.springboot.dto.UserDto;
import com.ibrahim.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUser();
    void deleteUser(UserDto userDto);
}
