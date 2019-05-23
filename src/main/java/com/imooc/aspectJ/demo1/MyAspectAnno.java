package com.imooc.aspectJ.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面类
 */
@Aspect
public class MyAspectAnno {

    @Before(value="execution(* com.imooc.aspectJ.demo1.ProductDao.save(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知=================="+joinPoint);
    }

    @AfterReturning(value = "execution(* com.imooc.aspectJ.demo1.ProductDao.update(..))")
    public void  afterReturning(){
        System.out.println("后置通知==================");
    }
}
