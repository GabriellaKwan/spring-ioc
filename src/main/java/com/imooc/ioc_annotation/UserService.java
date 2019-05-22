package com.imooc.ioc_annotation;

import com.imooc.ioc.demo4.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Spring 的Bean管理：注解方式
 * 传统方式需要去XML中配置<bean id="" class""/>
 */
//@Component("userService")
    @Service("userService")
public class UserService {
    //普通类型注释
    @Value("Pizza")
    private String something;
    //对象类型
//    @Autowired
//    @Qualifier("userDao111")
    @Resource(name="userDao111")
    private UserDao userDao;

    public String sayHello(String name){
        return "Hello "+name;
    }

    public void eat(){
        System.out.println("eat "+ something);
    }

    public void save(){
        System.out.println("Service中保存用户。。。");
        userDao.save();
    }
}
