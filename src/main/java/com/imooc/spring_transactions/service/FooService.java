package com.imooc.spring_transactions.service;

import com.mooc.beans.Foo;

public interface FooService {
     Foo getFoo(String name);

     Foo getFoo(String name, String barname);
     void insertFoo(Foo foo);
     void updateFoo(Foo foo);
}
