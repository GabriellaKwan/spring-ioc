package com.imooc.jdbc_template.dao;

import com.imooc.jdbc_template.entity.Course;

import java.util.List;

public interface CourseDao {
    void insert(Course course);
    void update(Course course);
    void delete(int id);
    Course select(int id);
    List<Course> selectAll();
}
