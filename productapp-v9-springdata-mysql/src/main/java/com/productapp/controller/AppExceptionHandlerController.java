package com.productapp.controller;

import com.productapp.dto.ErrorInfo;
import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice//AOP
public class AppExceptionHandlerController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorInfo> handle404(ProductNotFoundException  ex){
        ErrorInfo errorInfo=new ErrorInfo();
        errorInfo.setErrorMessage(ex.getMessage());
        errorInfo.setTimestamp(LocalDateTime.now());
        errorInfo.setStatusCode(HttpStatus.NOT_FOUND.toString());
        errorInfo.setToContact("rgupta.mtech@gmail.com");
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorInfo> handle500(Exception  ex){
//        ErrorInfo errorInfo=new ErrorInfo();
//        errorInfo.setErrorMessage("pls try after some time");
//        errorInfo.setTimestamp(LocalDateTime.now());
//        errorInfo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//        errorInfo.setToContact("rgupta.mtech@gmail.com");
//        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
//    }
    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException  ex){
        ErrorInfo errorInfo=new ErrorInfo();

        String errorMessage= ex.getBindingResult()
                        .getAllErrors()
                        .stream().map(e-> e.getDefaultMessage())
                        .collect(Collectors.joining(", "));


        errorInfo.setErrorMessage(errorMessage);
        errorInfo.setTimestamp(LocalDateTime.now());
        errorInfo.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorInfo.setToContact("rgupta.mtech@gmail.com");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
    }


}
