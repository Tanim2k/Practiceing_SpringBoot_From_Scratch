package com.ibrahim.springboot.controller;

import com.ibrahim.springboot.dto.UserDto;
import com.ibrahim.springboot.dtoimp.UserMapper;
import com.ibrahim.springboot.entity.User;
import com.ibrahim.springboot.exception.ExceptionDetails;
import com.ibrahim.springboot.exception.ResourceNotFoundException;
import com.ibrahim.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Tag(
        name = "Crud Rest Api for User Resource",
        description = "Create ,Get by id,Get All,Delete"
)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Rest API for Create a Customer",
            description = "Enter Values for a Customer"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 Created"
    )
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user)
    {
       UserDto addedUser= userService.createUser(user);
       return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Rest API for get a Customer",
            description = "Enter Id for a Customer"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int id)
    {
        UserDto addedUser= userService.getUserById(id);
        return new ResponseEntity<>(addedUser,HttpStatus.FOUND);
    }

    @Operation(
            summary = "Rest API for get All Customers",
            description = "Fetching from data base"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll()
    {
        List<UserDto>allUser=userService.getAllUser();

        return new ResponseEntity<>(allUser,HttpStatus.ACCEPTED);
    }
    @Operation(
            summary = "Rest API for delete a Customer",
            description = "Enter Values for a Customer"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserDto userDto)
    {
        userService.deleteUser(userDto);
    }


/*    @ExceptionHandler(ResourceNotFoundException.class) //It used in specific Exception
   public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                     WebRequest webRequest)
    {
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "User_Not_Found"
        );
         return new ResponseEntity<>(exceptionDetails,HttpStatus.NOT_FOUND);
    }*/
}
