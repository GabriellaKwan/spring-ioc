package com.imooc.ioc.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo4 {

    @Test
    /**
     * 构造方法DI属性注入
     */
    public void demo1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
