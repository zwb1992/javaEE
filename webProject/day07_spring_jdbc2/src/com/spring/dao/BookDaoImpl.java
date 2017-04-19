package com.spring.dao;

import com.spring.exception.BookStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by zwb on 17/4/7.
 *
 */
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int getPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn=?";
        int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return price;
    }

    @Override
    public int getStock(String isbn) {
        String sql = "select stock from book_stock where isbn=?";
        int stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return stock;
    }

    @Override
    public void updateStock(String isbn) {
        int stock = getStock(isbn);
        if (stock <= 0) {
            throw new BookStockException("图书库存不足");
        }
        String sql = "update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateBalance(String username, int price) {
        int balance = getBalanceByUsername(username);
        if (balance < price) {
            throw new BookStockException("账户余额不足");
        }
        String sql = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql, price, username);
    }

    @Override
    public int getBalanceByUsername(String username) {
        String sql = "select balance from account where username=?";
        int balance = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return balance;
    }
}
