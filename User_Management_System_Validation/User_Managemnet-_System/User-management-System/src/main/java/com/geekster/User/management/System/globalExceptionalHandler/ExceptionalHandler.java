package com.geekster.User.management.System.globalExceptionalHandler;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> exceptionMethod(MethodArgumentNotValidException description){
        Map<String,String> map = new HashMap<>();
        List<ObjectError> allErrors = description.getBindingResult().getAllErrors();
        for(ObjectError error : allErrors){
            String defaultMessage = error.getDefaultMessage();
            String code = error.getCode();
            map.put(code,defaultMessage);
        }
         return map;
    }
}
