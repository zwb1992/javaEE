package com.zwb.mybatis.dao;

import com.zwb.mybatis.bean.Account;

/**
 * Created by zwb on 17/4/27.
 * 接口式编程
 */
public interface AccountMapper {

    /**
     * 用这个方法去与AccountMapper.xml里面的sql绑定
     * @param id
     * @return
     */
    Account getAccountById(Integer id);

    long addAccount(Account account);

    boolean updateAccount(Account account);

    void deleteAccountById(Integer id);
}
