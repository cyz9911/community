package com.nowcoder.community.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {
    // 构造器
    public AlphaService() {
        System.out.println("实例化AlphaService");
    }

    @PostConstruct  //TODO 让IoC在构造器之后调用这个方法
    public void init() {
        System.out.println("初始化AlphaService");
    }

    @PreDestroy     // todo 在销毁Bean前调用该方法
    public void destroy() {
        System.out.println("销毁AlphaService");
    }
}












