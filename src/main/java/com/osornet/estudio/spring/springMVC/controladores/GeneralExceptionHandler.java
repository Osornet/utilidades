package com.osornet.estudio.spring.springMVC.controladores;

import java.io.IOException;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GeneralExceptionHandler
 */
@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        System.out.println(e.toString());
        return "error";
    }
    /* @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException e){
        System.out.println(e.toString());
        return "error";
    } */
    /* @ExceptionHandler(IOException.class)
    public String handleIOException(IOException e){
        System.out.println(e.toString());
        return "error";
    } */


}