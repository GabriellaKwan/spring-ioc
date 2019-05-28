package com.imooc.jdbc_template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

    @org.junit.Test
    public void testExecute(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate =  (JdbcTemplate) context.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table user1(id int, name varchar(20))");
    }
}
