package com.example.demo.ExceptionHandler;


import com.example.demo.domain.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 配置全局异常
 */
@RestControllerAdvice
public class CustomExtHandler {


    /**
     * 捕获全局异常
     */
//    @ExceptionHandler(value = Exception.class)
//    Object handlerException(Exception e, HttpServletRequest request){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code",-1);
//        map.put("msg",e.getMessage());
//        map.put("url",request.getRequestURI());
//        return map;
//    }


    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = MyException.class)
    Object handleMyException(Exception e, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }


}
