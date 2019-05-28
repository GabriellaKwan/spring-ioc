package com.imooc.jdbc_template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testUpdate(){
        String sql = "insert into student(name,sex) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{"张飞","男"});
    }

    @Test
    public void testUpdate2(){
        String sql = "update student set sex=? where id=?";
        jdbcTemplate.update(sql,"女",1);
    }

    //批量处理
    @Test
    public void testBatchUpdate(){
        String[] sqls={
                "insert into student(name,sex) values('关羽','女')",
                "insert into student(name,sex) values('刘备','男')",
                "update student set sex='女' where id=1"
        };
        jdbcTemplate.batchUpdate(sqls);
    }
    @Test
    public void testBatchUpdate2(){
        String sql = "insert into selection(student,course) values(?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{3,1001});
        list.add(new Object[]{4,1003});
        jdbcTemplate.batchUpdate(sql,list);
    }

    /**
     * 查询简单对象，获取Object或者List
     */
    @Test
    public void testQuerySimple1(){
        String sql = "select count(*) from student";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }
    @Test
    public void testQuerySimple2(){
        String sql = "select name from student where sex=?";
        List<String> names=jdbcTemplate.queryForList(sql,String.class, "女");
        System.out.println(names);
    }

    /**
     * 查询复杂对象，分装为Map
     * 获取一个对象
     */
    @Test
    public void testQueryMap1(){
        String sql = "select * from student where id =?";
        Map stu= jdbcTemplate.queryForMap(sql, 3);
        System.out.println(stu);
    }

    /**
     * 查询复杂对象，分装为Map
     * 获取多个对象，比较testQuerySimple2()
     */
    @Test
    public void testQueryMap2(){
        String sql = "select * from student";
        List<Map<String, Object>> stus = jdbcTemplate.queryForList(sql);
        System.out.println(stus);
    }

}
