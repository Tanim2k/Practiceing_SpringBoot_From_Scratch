package com.ibrahim.springboot.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class EmailAlreadyExists extends RuntimeException{
    private String message;

    public EmailAlreadyExists( String message1) {
        super(message1);
    }
}
