package com.ibrahim.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    //by default it contains default error message
    @NotEmpty(message = "Name should not be Null")
    private String firstName;
    @NotEmpty(message = "Name should not be Null")
    private String lastName;
    @NotEmpty(message = "Please enter a Valid email")
    @Email(message = "Enter a unique EMail address")
    private String email;
}
