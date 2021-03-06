package com.imooc.spring_transactions;

import com.imooc.spring_transactions.beans.Book;
import com.imooc.spring_transactions.beans.Foo;
import com.imooc.spring_transactions.beans.Xbean;
import com.imooc.spring_transactions.service.BookService;
import com.imooc.spring_transactions.service.FooService;
import com.imooc.spring_transactions.service.XbeanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

import java.sql.Date;

import static java.lang.System.out;

public class MainBoot {
    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/springContext.xml");//, MainBoot.class
        out.println(ctx);
        Book book = new Book("isbn-333-","古文大全",321.5f,new Date(System.currentTimeMillis()));
        BookService  bookService = (BookService)ctx.getBean("bookService");
        bookService.insertBook(book);
        Book bk = bookService.findBookByIsbn("isbn-333-");
        out.println(bk);
        /*out.println("事务模式："+((DataSource)ctx.getBean("dataSource")).getConnection().getAutoCommit());
        FooService fooService = (FooService) ctx.getBean("fooService");
        out.println(fooService);
        Foo f=fooService.getFoo("Dicker");
        out.println(f);
        fooService.insertFoo (new Foo());*/
        /*XbeanService xs = (XbeanService) ctx.getBean("xbeanService");
        out.println("读取Bean信息："+xs.getXbean(1234));
        xs.insertXbean(new Xbean());*/
    }
}
