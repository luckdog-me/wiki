package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: jie
 * @Date: 2022/1/2 15:43
 * @Description:
 */

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello post!" + name;
    }
}
