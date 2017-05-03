package com.zwb.mybatis.dao;


import com.zwb.mybatis.bean.Account;

import java.util.List;

/**
 * Created by zwb on 17/4/27.
 * 动态sql
 */
public interface AccountMapperDynamicSql {

    List<Account> getAccountsByConditionIf(Account account);
}
