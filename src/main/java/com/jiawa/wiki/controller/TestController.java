package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: jie
 * @Date: 2022/1/2 15:43
 * @Description:
 */

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
