package com.example.StreamAPI.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyAddedException extends RuntimeException {
    public AlreadyAddedException(String message){
        super(message);
    }
}