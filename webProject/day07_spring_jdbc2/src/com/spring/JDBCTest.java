package com.spring;

import com.spring.dao.BookDao;
import com.spring.service.BookService;
import com.spring.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

/**
 * Created by zwb on 17/4/7.
 * 测试
 */
public class JDBCTest {

    private ApplicationContext applicationContext;
    private JdbcTemplate jdbcTemplate;
    private BookDao bookDao;
    private BookService bookService;
    private Cashier cashier;
    {
        applicationContext = new ClassPathXmlApplicationContext("beans-properties.xml");
        jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        bookDao = applicationContext.getBean(BookDao.class);
        bookService = applicationContext.getBean(BookService.class);
        cashier = applicationContext.getBean(Cashier.class);
    }

    @Test
    public void testGetPrice(){
        System.out.println(bookDao.getPriceByIsbn("1001"));
    }

    @Test
    public void testUpdateStock(){
        bookDao.updateStock("1001");
    }

    @Test
    public void testGetStock(){
        System.out.println(bookDao.getStock("1001"));
    }

    @Test
    public void testGetBalance(){
        System.out.println(bookDao.getBalanceByUsername("张三"));
    }

    @Test
    public void testUpdateBalance(){
        bookDao.updateBalance("张三",50);
    }

    @Test
    public void testBookService(){
        bookService.purchase("张三","1001");
    }

    //测试事务的传播行为
    @Test
    public void testTransactionalPropagation(){
        cashier.checkout("张三", Arrays.asList("1001","1002"));
    }
}
