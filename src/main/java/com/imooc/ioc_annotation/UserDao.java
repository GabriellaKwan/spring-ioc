package com.imooc.ioc_annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao111")
public class UserDao {
    public void save(){
        System.out.println("DAO保存用户...");
    }
}
