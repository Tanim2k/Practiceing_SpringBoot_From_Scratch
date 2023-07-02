package com.ibrahim.springboot.controller;

import com.ibrahim.springboot.dto.UserDto;
import com.ibrahim.springboot.dtoimp.UserMapper;
import com.ibrahim.springboot.entity.User;
import com.ibrahim.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user)
    {
       UserDto addedUser= userService.createUser(user);
       return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int id)
    {
        UserDto addedUser= userService.getUserById(id);
        return new ResponseEntity<>(addedUser,HttpStatus.FOUND);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll()
    {
        List<UserDto>allUser=userService.getAllUser();

        return new ResponseEntity<>(allUser,HttpStatus.ACCEPTED);
    }
    @GetMapping("/delete")
    public void deleteUser(@RequestBody UserDto userDto)
    {
        userService.deleteUser(userDto);
    }
}
