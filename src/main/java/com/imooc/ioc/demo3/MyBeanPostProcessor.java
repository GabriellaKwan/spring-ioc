package com.imooc.ioc.demo3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 每一个bean被实例化的时候都会去调用这个类中的两个方法
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("第五步，BeanPostProcessor的before方法");
        //System.out.println("处理的bean是："+o+",它的名称是"+s );
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        //System.out.println("第八步：初始化后方法...");
        if("userDao".equals(beanName)) {
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if("save".equals(method.getName())){//如果方法是save，增强
                        System.out.println("增强测试，权限校验==========================");
                        return method.invoke(bean,args);//调用save方法
                    }
                    return method.invoke(bean,args);//直接调用其他方法
                }
            });
            return proxy;//不增强，返回原有bean
        }else{
            return bean;
        }
    }
}
