package dev.vishal.productservice.controller;

import dev.vishal.productservice.dtos.ErrorDTO;
import dev.vishal.productservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<ErrorDTO>(
                new ErrorDTO(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
