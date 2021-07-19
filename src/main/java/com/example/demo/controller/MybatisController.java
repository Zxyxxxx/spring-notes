package com.example.demo.controller;


import com.example.demo.domain.JsonData;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 整合mybatis
 */
@RestController
@RequestMapping("api/v1/mybatis")
public class MybatisController {


    @Autowired
    private UserService userService;


    @RequestMapping("/insert")
    public Object insert(User user){
        userService.insertUser(user);
        return JsonData.buildSuccess(user.getId());
    }



    @RequestMapping("/get")
    public Object get(Integer id){
        User user = userService.get(id);
        return JsonData.buildSuccess(user);
    }



    @GetMapping("test/exception")
    public Object test(){
        return 1/0;
    }


}
