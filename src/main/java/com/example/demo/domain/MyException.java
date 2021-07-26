package com.example.demo.domain;

import lombok.Data;

/**
 * 自定义异常处理
 */
@Data
public class MyException extends RuntimeException{


    public MyException(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private String code;
    private String msg;





}
