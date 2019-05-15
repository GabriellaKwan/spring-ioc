package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
    @Test
    /**
     * 传统方式开发
     */
    public void demo1(){
        UserService userService= new UserServiceImpl();
        userService.sayHello();
    }
    @Test
    /**
     * Spring 方式实现
     */
    public void demo2(){
        //创建Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类,s为bean中的id
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();
    }

}

