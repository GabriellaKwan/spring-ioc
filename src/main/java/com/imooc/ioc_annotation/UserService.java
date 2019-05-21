package com.imooc.ioc_annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Spring 的Bean管理：注解方式
 * 传统方式需要去XML中配置<bean id="" class""/>
 */
//@Component("userService")
    @Service("userService")
public class UserService {
    public String sayHello(String name){
        return "Hello "+name;
    }
}
