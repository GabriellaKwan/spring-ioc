package com.imooc.ioc.demo1;

public class UserServiceImpl implements UserService{
    @Override
    public void sayHello() {

        System.out.println("Hello, Spring!");
    }
}