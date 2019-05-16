package com.imooc.ioc.demo2;

/**
 *Bean3的实例工厂
 * 与Bean2静态工厂构造的区别在于，静态工厂构造函数为static类型，实例工厂不是static
 */
public class Bean3Factory {
    public Bean3 createBean3(){
        System.out.println("Beans3Factory已经被执行了...");
        return new Bean3();
    }
}
