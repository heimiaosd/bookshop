package com.example.bookshop_admin.support;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> handleException(RuntimeException exception){
        Map<String,Object> result = new HashMap<>();
        result.put("result", "fail");
        result.put("errmsg",exception.getMessage());
        return result;
    }
}
