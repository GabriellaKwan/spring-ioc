package com.imooc.jdbc_template.dao;

import com.imooc.jdbc_template.entity.Selection;

import java.util.List;
import java.util.Map;

public interface SelectionDao {
    void insert(List<Selection> seles);//插入多个，根据实际需要
    void delete(int sid,int cid);//查询多个
    List<Map<String,Object>> selectByStudent(int sid);
    List<Map<String,Object>> selectByCourse(int cid);
}
