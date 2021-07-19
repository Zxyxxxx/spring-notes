package com.example.demo.ExceptionHandler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置全局异常
 */
@RestControllerAdvice
public class CustomExtHandler {


    /**
     * 捕获全局异常
     */
    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURI());
        return map;
    }


}
