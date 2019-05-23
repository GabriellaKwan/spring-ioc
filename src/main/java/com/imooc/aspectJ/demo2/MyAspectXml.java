package com.imooc.aspectJ.demo2;

import org.aspectj.lang.JoinPoint;

public class MyAspectXml {


    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("XML方式的前置通知==========="+joinPoint);
    }


}
