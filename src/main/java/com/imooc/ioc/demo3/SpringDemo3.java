package com.imooc.ioc.demo3;

import com.imooc.ioc.demo3.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {
    @Test
    /**
     * Bean的作用范围的测试
     */
    public void demo1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = (Person)applicationContext.getBean("Person");
        Person person2 = (Person)applicationContext.getBean("Person");
        System.out.println(person1);
        System.out.println(person2);
    }

    /**
     * Bean生命周期测试
     */
    @Test
    public void demo2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man) applicationContext.getBean("man");

        man.run();

        applicationContext.close();
    }

    /**
     * Bean增强save()测试
     */
    @Test
    public void demo3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        userDao.findAll();
        userDao.save();
        userDao.update();
        userDao.delete();

    }
}
