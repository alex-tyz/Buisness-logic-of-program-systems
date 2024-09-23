package org.senechka.lab1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.handler.ExceptionHandlingWebHandler;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyTownListException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmptyTownListException(String msg) {
        super(msg);
    }

}