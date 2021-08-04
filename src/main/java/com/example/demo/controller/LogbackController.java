package com.example.demo.controller;


import com.example.demo.domain.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LogbackController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("log")
    public Object testlog() {
        logger.debug("this is debug");
        logger.info("this is info");
        logger.warn("this is warn");
        logger.error("this is error");
        return JsonData.buildSuccess();
    }


}
