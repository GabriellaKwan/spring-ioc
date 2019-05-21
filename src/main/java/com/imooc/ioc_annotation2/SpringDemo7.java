package com.imooc.ioc_annotation2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo7 {
    /**
     * Bean生命周期的注解
     * @PostConstruct
     * @PreDestroy
     */
    @Test
    public void demo1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        bean1.say();
        applicationContext.close();
    }


    /**
     *Bean生命周期的其他注解
     * @Scope()
     * 默认是singleton，可改为"prototype"多例，下为测试代码，通过观察bean1与bean2地址是否相同
     */
    @Test
    public void demo2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean1 = (Bean2) applicationContext.getBean("bean2");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");

        System.out.println(bean1==bean2);
    }
}
