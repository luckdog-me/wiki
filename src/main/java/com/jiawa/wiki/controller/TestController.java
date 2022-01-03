package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: jie
 * @Date: 2022/1/2 15:43
 * @Description:
 */

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @Value("${test.hello:Test}")
    private String testHello;

    @GetMapping("/hello")
    public String hello(){
        return "hello world!" + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello post!" + name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }

}
