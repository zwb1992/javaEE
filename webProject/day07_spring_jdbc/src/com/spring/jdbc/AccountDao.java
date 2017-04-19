package com.spring.jdbc;

import com.spring.bean.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by zwb on 17/4/6.
 */
@Repository
public class AccountDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public AccountInfo get(int id) {
        String sql = "select * from account_info where id=?";
        RowMapper<AccountInfo> rowMapper = new BeanPropertyRowMapper<>(AccountInfo.class);
        AccountInfo accountInfo = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return accountInfo;
    }
}
