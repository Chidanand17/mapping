package com.demomap.mapping.exception;

import com.demomap.mapping.payload.Errordetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalhandlerExcpt extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Resourcenotfound.class)
    public ResponseEntity<Errordetails> handlingexpt(Resourcenotfound excption, WebRequest webRequest){
        Errordetails errordetails = new Errordetails(new Date(), excption.getMessage(),webRequest.getDescription(false));
        return new  ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler
    public  ResponseEntity<Errordetails> Handleexpt(Exception exception,WebRequest webRequest){
        Errordetails errordetails = new Errordetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return  new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
