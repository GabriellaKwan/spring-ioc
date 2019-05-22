package com.imooc.aspectJ.demo1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面类
 */
@Aspect
public class MyAspectAnno {

    @Before(value="execution(* com.imooc.aspectJ.demo1.ProductDao.*(..))")
    public void before(){
        System.out.println("前置通知==================");
    }
}
