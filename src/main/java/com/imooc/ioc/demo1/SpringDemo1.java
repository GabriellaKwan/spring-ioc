package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class SpringDemo1 {
    @Test
    /**
     * 传统方式开发
     * 如果有属性，需要修改源代码，对于程序设计存在耦合问题
     */
    public void demo1(){
        UserService userService= new UserServiceImpl();
        //设置属性,接口里没有设置name 方法，只有实现类Impl里有
        //所以需要new 实现类
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setName("张三");
        userService.sayHello();
    }
    @Test
    /**
     * Spring 方式实现
     * 在impl中设置属性，getter 和setter方法
     * 修改配置文件，设置属性property标签，直接调用
     */
    public void demo2(){
        //创建Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过工厂获得类,s为bean中的id
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();
    }

    @Test
    /**
     * 读取磁盘系统中的配置文件
     */
    public void demo3(){
        //创建Spring的工厂类
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("d:\\applicationContext.xml");
        //通过工厂获得类,s为bean中的id
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sayHello();
    }

    @Test
    /**
     * 传统方式的工厂类BeanFactory
     */
    public void demo4(){
        //创建工厂类
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //通过工厂获得类,s为bean中的id
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }

    @Test
    /**
     * 传统方式的工厂类BeanFactory
     */
    public void demo5(){
        //创建工厂类
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("d:\\applicationContext.xml"));
        //通过工厂获得类,s为bean中的id
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.sayHello();
    }
}

