package com.imooc.ioc_annotation3;

import com.imooc.ioc.demo4.Product;
import com.imooc.ioc_annotation2.Bean2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo8 {
    /**
     *结合XML和属性注入方式
     */
    @Test
    public void demo1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService = (ProductService) applicationContext.getBean("productService");
        productService.save();
    }
}
