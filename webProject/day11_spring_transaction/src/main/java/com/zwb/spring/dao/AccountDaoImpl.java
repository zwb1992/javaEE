package com.zwb.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by zwb on 17/4/26.
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void outMoney(String account, double money) {
        String sql = "update account SET money = money - ? where name = ?";
        jdbcTemplate.update(sql,money,account);
    }

    public void inMoney(String account, double money) {
        String sql = "update account SET money = money + ? where name = ?";
        jdbcTemplate.update(sql,money,account);
    }
}
