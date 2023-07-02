package com.ibrahim.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice  //we use it when we want to use global exception
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) //It used in specific Exception
    public ResponseEntity<ExceptionDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                            WebRequest webRequest)
    {
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "User_Not_Found"
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExists.class) //It used in specific Exception
    public ResponseEntity<ExceptionDetails> handleEmailAlreadyExists(EmailAlreadyExists emailAlreadyExists,
                                                                            WebRequest webRequest)
    {
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                emailAlreadyExists.getMessage(),
                webRequest.getDescription(false),
                "Email is already Taken"
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class) //It used in specific Exception
    public ResponseEntity<ExceptionDetails> handleDefaultException(Exception exception,
                                                                     WebRequest webRequest)
    {
        ExceptionDetails exceptionDetails=new ExceptionDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "Default Exception so Please Find it by your own"
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
