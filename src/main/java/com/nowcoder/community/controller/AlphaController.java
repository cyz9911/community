package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody   //声明返回普通字符串，不然就是返回网页
    public String sayHello(){
        return "Hello Spring Boot.";
    }
}







