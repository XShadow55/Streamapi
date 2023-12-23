package com.example.StreamAPI;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AlreadyAddedException extends RuntimeException {
    public AlreadyAddedException(String message){
        super(message);
    }
}