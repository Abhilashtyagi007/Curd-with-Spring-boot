package com.curd.exceptions;

import com.curd.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse res = ApiResponse.builder().success(true).message(message).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }
}
