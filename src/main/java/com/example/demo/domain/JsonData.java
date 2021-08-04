package com.example.demo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private Object data;
    private String msg;


    public JsonData() {
    }

    ;

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }


    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }


    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }


}
