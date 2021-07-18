package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private Integer num;

    private Date createDate;


}
