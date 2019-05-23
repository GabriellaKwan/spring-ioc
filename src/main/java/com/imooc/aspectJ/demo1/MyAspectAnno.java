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

    @Before(value="myPointcut1()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知=================="+joinPoint);
    }

    @AfterReturning(value = "myPointcut2()",returning = "result")
    public void  afterReturning(Object result){
        System.out.println("后置通知=================="+result);
    }

    @Around(value = "myPointcut3()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知==============");
        Object obj = joinPoint.proceed(); //执行目标方法
        System.out.println("环绕后通知==============");
        return obj;
    }

    @AfterThrowing(value = "myPointcut4()",throwing = "error")
    public void afterThrowing(Throwable error){
        System.out.println("异常跑出通知=============="+error);
    }

    @After(value = "myPointcut5()")
    public void after(){
        System.out.println("最终通知==============");
    }

    //通过@Pointcut为切点命名，代码维护起来更方便，只需修改方法名即可
    //切点方法：private void 方法名为切点名，无参数方法
    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.save(..))")
    private void myPointcut1(){}
    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.update(..))")
    private void myPointcut2(){}
    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.delete(..))")
    private void myPointcut3(){}
    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.findOne(..))")
    private void myPointcut4(){}
    @Pointcut(value="execution(* com.imooc.aspectJ.demo1.ProductDao.findAll(..))")
    private void myPointcut5(){}
}
