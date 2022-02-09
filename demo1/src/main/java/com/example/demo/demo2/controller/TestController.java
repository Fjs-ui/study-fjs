package com.example.demo.demo2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: fjs
 * @create: 2022-02-08 16:45
 **/
@RestController
@RequestMapping("/aopTest")
public class TestController {

    @PostMapping("/a")
    public String test(){
        System.out.println("方法本体");
        return "hello";
    }
}
