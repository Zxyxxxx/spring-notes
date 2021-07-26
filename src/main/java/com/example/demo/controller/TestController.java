package com.example.demo.controller;

import com.example.demo.domain.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/v1/api")
public class TestController {


    @GetMapping("test")
    public Object test(){
        return JsonData.buildSuccess();
    }

}
