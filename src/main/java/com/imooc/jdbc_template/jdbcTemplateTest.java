package com.imooc.jdbc_template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//注解方法
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_jdbcTemplate.xml")
public class jdbcTemplateTest {

//    //构造初始化块，方便以后获取JdbcTemplate对象,以后的测试方法可以直接获取
//    private JdbcTemplate jdbcTemplate;
//    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_jdbcTemplate.xml");
//        JdbcTemplate jdbcTemplate =  (JdbcTemplate) context.getBean("jdbcTemplate");
//    }

    @Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testExecute(){
        jdbcTemplate.execute("create table user2(id int, name varchar(20))");
    }

}
