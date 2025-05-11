package com.test.project.Restfull.web.services.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {


    //If we want to return our own response entity for any exception
    //we can make use of our own structure like below ErrorMessageFormat
    @ExceptionHandler
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorMessageFormat error = new ErrorMessageFormat(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorMessageFormat error = new ErrorMessageFormat(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
