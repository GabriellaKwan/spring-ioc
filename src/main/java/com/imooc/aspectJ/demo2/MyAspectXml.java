package com.imooc.aspectJ.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXml {


    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("XML方式的前置通知==========="+joinPoint);
    }
    // 后置通知
    public void afterReturning(Object result){
        System.out.println("XML方式的后置通知=============="+ result );
    }


}
