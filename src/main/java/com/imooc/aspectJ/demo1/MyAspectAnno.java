package com.imooc.aspectJ.demo1;

import javafx.beans.binding.ObjectExpression;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 */
@Aspect
public class MyAspectAnno {

    @Before(value="execution(* com.imooc.aspectJ.demo1.ProductDao.save(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知=================="+joinPoint);
    }

    @AfterReturning(value = "execution(* com.imooc.aspectJ.demo1.ProductDao.update(..))",returning = "result")
    public void  afterReturning(Object result){
        System.out.println("后置通知=================="+result);
    }

    @Around(value = "execution(* com.imooc.aspectJ.demo1.ProductDao.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知==============");
        Object obj = joinPoint.proceed(); //执行目标方法
        System.out.println("环绕后通知==============");
        return obj;
    }

    @AfterThrowing(value = "execution(* com.imooc.aspectJ.demo1.ProductDao.findOne(..))")
    public void afterThrowing(){
        System.out.println("异常跑出通知==============");
    }
}
