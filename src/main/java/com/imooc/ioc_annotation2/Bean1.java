package com.imooc.ioc_annotation2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("bean1")
public class Bean1 {
    @PostConstruct
    public void init(){
        System.out.println("initBean1...");
    }

    public void say(){
        System.out.println("sayBean1...");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroyBean1...");
    }
}
