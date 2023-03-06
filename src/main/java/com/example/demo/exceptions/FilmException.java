package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class FilmException extends RuntimeException{
    private HttpStatus httpStatus;

    public FilmException(HttpStatus httpStatus, String message){
        super(message);
        this.httpStatus = httpStatus;
    }
}
