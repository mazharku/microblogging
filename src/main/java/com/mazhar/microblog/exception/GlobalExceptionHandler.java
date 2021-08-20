package com.mazhar.microblog.exception;

import com.mazhar.microblog.util.AppResponse;
import com.mazhar.microblog.webService.BlogPostResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleException(ResourceNotFound resourceNotFound) {
        log.error(resourceNotFound.getMessage());
        return new ResponseEntity<Object>(AppResponse.operationFail(resourceNotFound.getMessage()), new HttpHeaders(),
                HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityException(EntityNotFoundException e) {
        log.error(e.getMessage());
        return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
                HttpStatus.OK);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEntityException(EmptyResultDataAccessException e) {
        log.error(e.getMessage());
        return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
                HttpStatus.OK);
    }
}
